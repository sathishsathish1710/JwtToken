package com.example.jwtdemo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    // any additional methods for item retrieval or manipulation
}
