package com.example.springbootjava;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoInterface extends MongoRepository<Character, String> {
}
