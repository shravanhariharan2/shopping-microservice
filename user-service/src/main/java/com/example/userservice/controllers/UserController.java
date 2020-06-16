package com.example.userservice.controllers;

import java.util.List;

import com.example.userservice.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @GetMapping("/")
  public List<User> getUsers() {
    return null;
  }

  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id) {
    return null;
  }
}