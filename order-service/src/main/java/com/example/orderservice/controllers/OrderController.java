package com.example.orderservice.controllers;

import java.util.List;

import com.example.orderservice.models.Order;

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
    return null;
  }

  @GetMapping("/{userId}")
  public Order getOrder(@PathVariable("userId") String userId) {
    return null;
  }

  @PostMapping("/")
  public Order postOrder(@RequestBody Order order) {
    return null;
  }

}