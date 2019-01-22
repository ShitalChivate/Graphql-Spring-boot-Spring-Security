package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor
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
