package com.example.orderservice.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.orderservice.models.Item;
import com.example.orderservice.models.ItemReference;
import com.example.orderservice.models.ItemResponse;
import com.example.orderservice.models.Order;
import com.example.orderservice.models.OrderItem;
import com.example.orderservice.models.OrderRequest;
import com.example.orderservice.models.OrderResponse;
import com.example.orderservice.models.User;
import com.example.orderservice.repository.OrderItemRepository;
import com.example.orderservice.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  
  @Autowired
  public OrderRepository orderRepository;
  @Autowired
  public OrderItemRepository orderItemRepository;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @GetMapping("/")
  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  @GetMapping("/{userId}")
  public List<Order> getOrdersByUserId(@PathVariable Long userId) {
    return orderRepository.findAllByuserId(userId);
  }

  @PostMapping("/")
  public OrderResponse postOrder(@RequestBody OrderRequest orderRequest) {
    ItemResponse itemResponse = webClientBuilder.build()
                    .put()
                    .uri("http://item-service/api/v1/items/")
                    .body(Mono.just(orderRequest.getItems()), ItemReference.class).retrieve()
                    .bodyToMono(ItemResponse.class).block();
    
    List<Item> items = itemResponse.getItems();
    int totalPrice = items.stream().mapToInt(item -> item.getPrice()).sum();
    
    User user = webClientBuilder.build()
                    .put()
                    .uri("http://user-service/api/v1/users/" + orderRequest.getUserId())
                    .body(Mono.just(totalPrice), Integer.class).retrieve()
                    .bodyToMono(User.class).block();
    
    Order order = new Order(totalPrice, orderRequest.getUserId(), LocalDate.now().toString());
    order = orderRepository.save(order);

    List<OrderItem> orderItems = new ArrayList<>();
    for(ItemReference itemRef : orderRequest.getItems()) {
      orderItems.add(new OrderItem(order.getId(), itemRef.getItemId(), itemRef.getQuantity()));
    }
    Iterable<OrderItem> orderItemsIterable = orderItemRepository.saveAll(orderItems);
    orderItems = StreamSupport.stream(orderItemsIterable.spliterator(), false).collect(Collectors.toList());
    
    // create Item[] array
    Item[] itemsResponse = items.toArray(new Item[0]);
    OrderResponse response = new OrderResponse(order.getId(), user, order.getDateOrdered(), itemsResponse);

    return response;
  }
}
