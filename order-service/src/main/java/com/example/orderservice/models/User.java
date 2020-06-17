package com.example.orderservice.models;

public class User {
  private String email;
  private String firstName;
  private String lastName;
  private String address;
  private int points;

  public User() {}

  public User(String email, String firstName, String lastName, String address, int points) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.points = points;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
