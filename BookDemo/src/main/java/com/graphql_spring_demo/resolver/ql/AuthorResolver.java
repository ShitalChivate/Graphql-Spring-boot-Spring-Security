package com.graphql_spring_demo.resolver.ql;


import java.util.List;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql_spring_demo.pojo.Author;
import com.graphql_spring_demo.pojo.Post;
import com.graphql_spring_demo.repository.PostRepository;


public class AuthorResolver implements GraphQLResolver<Author> {

	
	public AuthorResolver(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	private  PostRepository postRepository;
	
	public List<Post> posts(Author auth) {
		return postRepository.findByAuthorId(auth.getId());
	}

}
