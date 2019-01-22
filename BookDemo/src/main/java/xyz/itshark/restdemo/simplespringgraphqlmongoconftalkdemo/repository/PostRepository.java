package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;


public interface PostRepository extends MongoRepository<Post,String> {
	List<Post> findByAuthorId(String authorId);

}
