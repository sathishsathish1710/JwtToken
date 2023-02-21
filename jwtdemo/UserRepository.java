package com.example.jwtdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends MongoRepository<Item, String> {

	User findByUsername(String username);
    
}

