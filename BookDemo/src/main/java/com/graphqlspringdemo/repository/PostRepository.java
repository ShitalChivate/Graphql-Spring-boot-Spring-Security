package com.graphqlspringdemo.repository;

import com.graphqlspringdemo.pojo.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PostRepository extends MongoRepository<Post,String> {
	List<Post> findByAuthorId(String authorId);

}
