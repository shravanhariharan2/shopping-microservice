package com.example.orderservice.models;

public class ItemReference {
  private String itemId;
  private int quantity;

  public ItemReference(String itemId, int quantity) {
    this.itemId = itemId;
    this.quantity = quantity;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
