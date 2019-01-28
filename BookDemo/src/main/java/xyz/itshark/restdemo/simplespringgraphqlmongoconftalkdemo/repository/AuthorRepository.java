package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {
      Author findById(String authorId);


}