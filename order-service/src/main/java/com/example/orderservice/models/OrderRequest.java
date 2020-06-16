package com.example.orderservice.models;

public class OrderRequest {
  private String userId;
  private ItemReference[] items;

  public OrderRequest(String userId, ItemReference[] items) {
    this.userId = userId;
    this.items = items;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ItemReference[] getItems() {
    return items;
  }

  public void setItems(ItemReference[] items) {
    this.items = items;
  }
  
}
