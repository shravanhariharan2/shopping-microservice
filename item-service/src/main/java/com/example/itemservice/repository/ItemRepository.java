package com.example.itemservice.repository;

import java.util.List;

import com.example.itemservice.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
  List<Item> findAll();
  Item findById(long id);
}