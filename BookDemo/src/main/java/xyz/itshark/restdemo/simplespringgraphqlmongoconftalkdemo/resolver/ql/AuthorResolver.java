package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;


import java.util.List;
import com.coxautodev.graphql.tools.GraphQLResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;


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
