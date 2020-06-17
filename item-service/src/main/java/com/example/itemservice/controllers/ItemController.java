package com.example.itemservice.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.itemservice.models.Item;
import com.example.itemservice.models.ItemReference;
import com.example.itemservice.models.ItemResponse;
import com.example.itemservice.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PutMapping("/")
  public ItemResponse putItems(@RequestBody List<ItemReference> itemReferences) {
    List<Long> ids = itemReferences.stream().map(ItemReference::getItemId).collect(Collectors.toList());
    Iterable<Item> itemsIter = repository.findAllById(ids);
    itemsIter.forEach(item -> {
      ItemReference itemRef = itemReferences.stream().filter(itemReference -> itemReference.getItemId().equals(item.getId())).findFirst().orElse(null);
      item.setQuantity(item.getQuantity() - itemRef.getQuantity());
    });
    Iterable<Item> resIterable = repository.saveAll(itemsIter);
    List<Item> items = StreamSupport.stream(resIterable.spliterator(), false).collect(Collectors.toList());
    return new ItemResponse(items);
  }
}