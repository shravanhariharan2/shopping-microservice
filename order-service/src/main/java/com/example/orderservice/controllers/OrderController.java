package com.example.orderservice.controllers;

import java.util.Collections;
import java.util.List;

import com.example.orderservice.models.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  
  @GetMapping("/")
  public List<Order> getOrders() {
    return Collections.singletonList(
      new Order(1000)
    );
  }
}