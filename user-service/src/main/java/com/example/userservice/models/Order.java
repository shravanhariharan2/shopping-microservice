package com.example.userservice.models;

import java.util.List;

public class Order {
  private int totalPrice;
  private String userId;
  private List<Item> items;
  private String dateOrdered;

  public Order() {}

  public Order(int totalPrice, String userId, List<Item> items, String dateOrdered) {
    this.totalPrice = totalPrice;
    this.userId = userId;
    this.items = items;
    this.dateOrdered = dateOrdered;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public String getDateOrdered() {
    return dateOrdered;
  }

  public void setDateOrdered(String dateOrdered) {
    this.dateOrdered = dateOrdered;
  }
  
}