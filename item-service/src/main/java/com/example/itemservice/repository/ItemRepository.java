package com.example.itemservice.repository;

import java.util.List;

import com.example.itemservice.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
  List<Item> find();
  Item findById(long id);
}