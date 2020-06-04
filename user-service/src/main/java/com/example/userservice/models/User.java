package com.example.userservice.models;

public class User {
  private String username;
  private int points;

  public User(String username, int points) {
    this.username = username;
    this.points = points;
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
  
}
