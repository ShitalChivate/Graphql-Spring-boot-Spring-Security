package com.graphqlspringdemo.repository;

import com.graphqlspringdemo.model.JwtUser;
//import com.graphqlspringdemo.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<JwtUser, String> {
    JwtUser findByUserName(String userName);
}