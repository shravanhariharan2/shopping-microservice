package com.example.orderservice.controllers;

import java.util.Collections;
import java.util.List;

import com.example.orderservice.models.Order;
import com.example.orderservice.models.Item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  
  @GetMapping("/")
  public List<Order> getOrders() {
    List<Item> items = Collections.singletonList(new Item("acm shot glass", 100, 1));
    return Collections.singletonList(
      new Order(100, "1", items, "6/5/20")
    );
  }

  @GetMapping("/{userId}")
  public Order getOrder(@PathVariable("userId") String userId) {
    List<Item> items = Collections.singletonList(new Item("acm shot glass", 100, 1));
    return new Order(200, userId, items, "6/5/20");
  }

  @PostMapping("/")
  public Order postOrder(@RequestBody Order order) {
    // TODO: update database
    return order;
  }

}