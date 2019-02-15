package com.graphqlspringdemo.repository;

import com.graphqlspringdemo.pojo.Author;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AuthorRepository extends MongoRepository<Author, String> {
      Author findById(String authorId);


}