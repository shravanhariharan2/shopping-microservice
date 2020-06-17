package com.example.orderservice.models;

public class ItemReference {
  private Long itemId;
  private int quantity;

  public ItemReference() {}

  public ItemReference(Long itemId, int quantity) {
    this.itemId = itemId;
    this.quantity = quantity;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
