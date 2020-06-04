package com.example.userservice.controllers;

import java.util.Collections;
import java.util.List;

import com.example.userservice.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
  @GetMapping("/")
  public List<User> getUsers() {
    return Collections.singletonList(
      new User("shrav", 0)
    );
  }
}