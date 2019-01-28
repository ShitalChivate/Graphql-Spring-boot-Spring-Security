package com.graphql_spring_demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.graphql_spring_demo.pojo.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {
      Author findById(String authorId);


}