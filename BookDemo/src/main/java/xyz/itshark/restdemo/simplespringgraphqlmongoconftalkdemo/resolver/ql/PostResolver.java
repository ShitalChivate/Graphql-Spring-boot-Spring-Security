package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;


@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {
	
	
	public PostResolver(AuthorRepository authRepository) {
		super();
		this.authRepository = authRepository;
	}

	private  AuthorRepository authRepository;

}
