package com.example.itemservice.controllers;

import java.util.Collections;
import java.util.List;

import com.example.itemservice.models.Item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
  
  @GetMapping("/")
  public List<Item> getItems() {
    return Collections.singletonList(
      new Item("foo", "a piece of foo", 20, 2)
    );
  }

  @PostMapping("/")
  public Item postItem(@RequestBody Item item) {
    return item;
  }
}