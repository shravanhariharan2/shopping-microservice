package com.example.orderservice.models;

public class Order {
  private int totalPrice;

  public Order(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }
  
}