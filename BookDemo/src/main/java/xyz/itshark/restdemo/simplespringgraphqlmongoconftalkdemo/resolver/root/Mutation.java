package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor

public class Mutation implements GraphQLRootResolver {
	
	
	public Mutation(AuthorRepository authRepo, PostRepository postRepo) {
		super();
		this.authRepo = authRepo;
		this.postRepo = postRepo;
	}

	private  AuthorRepository authRepo;
	private  PostRepository postRepo;

	public Author addAuthor(String pname,String price) {

		return authRepo.save(new Author(null, pname,price));
	}
	
	public Post orderProceed(String id,String orderProceed) {
		Post post=postRepo.findOne((id));
		System.out.println(post);
		post.setOrderProceed(orderProceed);
		return post;
	}
	
	public Post addOrder( String quantity, String authorId) {
		Author auth = authRepo.findOne(authorId);
		Author authPrice = authRepo.findOne(authorId);
		System.out.println(authPrice);
		int Price=Integer.parseInt(authPrice.getPrice());
		System.out.println(Price);

		if(auth != null) {

			Post post = new Post(null,quantity);
			int total  = Price*Integer.parseInt(quantity);
			post.setTitle(""+total);
			post.setAuthorId(authorId);
			return postRepo.save(post);
		}
		else 
			return null;
	}

	public Author updateAuthor(String id,String authorName,String price) {
		Author author=new Author(id,authorName,price);
		System.out.println(author);
		String empty=author.getId();
		System.out.println(empty);
		author.setPrice(price);
		author.setAuthorName(authorName);
		return  authRepo.save(author);

	}

	public Author deleteAuthor(String id){

		Author auth = authRepo.findOne(id);
		authRepo.delete(id);
		return auth;
	}
}

