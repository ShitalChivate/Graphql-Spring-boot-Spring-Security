package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;


public class PostResolver implements GraphQLResolver<Post> {

	private  AuthorRepository authRepository;

	public PostResolver(AuthorRepository authRepository) {
		super();
		this.authRepository = authRepository;
	}

}
