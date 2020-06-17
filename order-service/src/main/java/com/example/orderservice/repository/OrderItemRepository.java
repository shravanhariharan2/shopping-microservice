package com.example.orderservice.repository;

import com.example.orderservice.models.OrderItem;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}