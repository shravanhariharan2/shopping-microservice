package com.example.orderservice.repository;

import java.util.List;

import com.example.orderservice.models.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> findAll();
  List<Order> findAllByuserId();
}