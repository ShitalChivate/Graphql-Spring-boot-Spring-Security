package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;

import java.util.*;

public interface AuthorRepository extends MongoRepository<Author, String> {
//    List<Author> findByAuthorId(String authorId);
      Author findById(String authorId);



}