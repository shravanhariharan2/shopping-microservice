package com.example.itemservice.controllers;

import java.util.List;
import java.util.Optional;

import com.example.itemservice.models.Item;
import com.example.itemservice.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
  
  @Autowired
  public ItemRepository repository;

  @GetMapping("/")
  public List<Item> getItems() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Item> getItem(@PathVariable Long id) {
    return repository.findById(id);
  }

  @PostMapping("/")
  public Item postItem(@RequestBody Item item) {
    return repository.save(item);
  }
}