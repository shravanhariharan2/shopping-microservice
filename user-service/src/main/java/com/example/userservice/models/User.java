package com.example.userservice.models;

import java.util.List;

public class User {
  private String username;
  private int points;
  private List<Order> orders;

  public User(String username, int points, List<Order> orders) {
    this.username = username;
    this.points = points;
    this.orders = orders;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
  
}
