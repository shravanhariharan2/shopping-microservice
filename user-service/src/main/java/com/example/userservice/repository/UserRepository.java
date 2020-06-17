package com.example.userservice.repository;

import java.util.List;
import com.example.userservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  List<User> findAll();
  User findByid(Long id);
}
  
