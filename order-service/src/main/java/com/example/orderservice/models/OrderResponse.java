package com.example.orderservice.models;

public class OrderResponse {
  private Long id;
  private User customer;
  private String createdAt;
  private Item[] items;

  public OrderResponse() {}

  public OrderResponse(Long id, User customer, String createdAt, Item[] items) {
    this.id = id;
    this.customer = customer;
    this.createdAt = createdAt;
    this.items = items;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getCustomer() {
    return customer;
  }

  public void setCustomer(User customer) {
    this.customer = customer;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Item[] getItems() {
    return items;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }
}
