package com.graphql_spring_demo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql_spring_demo.pojo.Post;
import com.graphql_spring_demo.repository.AuthorRepository;


public class PostResolver implements GraphQLResolver<Post> {

	private AuthorRepository authRepository;

	public PostResolver(AuthorRepository authRepository) {
		super();
		this.authRepository = authRepository;
	}

}
