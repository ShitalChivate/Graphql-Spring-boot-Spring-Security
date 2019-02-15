package com.graphqlspringdemo.repository;

import com.graphqlspringdemo.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
}