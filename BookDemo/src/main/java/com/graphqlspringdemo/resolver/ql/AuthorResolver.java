package com.graphqlspringdemo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqlspringdemo.pojo.Author;
import com.graphqlspringdemo.pojo.Post;
import com.graphqlspringdemo.repository.PostRepository;

import java.util.List;

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
