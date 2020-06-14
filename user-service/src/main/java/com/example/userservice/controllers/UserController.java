package com.example.userservice.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.userservice.models.Order;
import com.example.userservice.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
  @Autowired
  private WebClient.Builder webClientBuilder;

  @GetMapping("/")
  public List<User> getUsers() {
    Order order = webClientBuilder.build()
          .get()
          .uri("http://order-service/api/orders/1")
          .retrieve()
          .bodyToMono(Order.class)
          .block();
    return Arrays.asList(new User("shrav", 10, Collections.singletonList(order)));
  }
}