package com.graphqlspringdemo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqlspringdemo.pojo.Post;
import com.graphqlspringdemo.repository.AuthorRepository;


public class PostResolver implements GraphQLResolver<Post> {

	private AuthorRepository authRepository;

	public PostResolver(AuthorRepository authRepository) {
		super();
		this.authRepository = authRepository;
	}

}
