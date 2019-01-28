package com.graphql_spring_demo.repository;

import java.util.List;

import com.graphql_spring_demo.pojo.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post,String> {
	List<Post> findByAuthorId(String authorId);

}
