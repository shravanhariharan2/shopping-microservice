package com.example.userservice.controllers;

import java.util.List;

import com.example.userservice.models.User;
import com.example.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  public UserRepository repository;

  @GetMapping("/")
  public List<User> getUsers() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id) {
    return repository.findByid(id);
  }

  @PostMapping("/")
  public User postUser(@RequestBody User user) {
    return repository.save(user);
  }

  @PutMapping("/{id}")
  public User putUser(@RequestBody Integer pointsDeducted, @PathVariable Long id) {
    System.out.println(pointsDeducted);
    System.out.println(id);
    User user = repository.findByid(id);
    user.setPoints(user.getPoints() - pointsDeducted);
    return repository.save(user);
  }
}