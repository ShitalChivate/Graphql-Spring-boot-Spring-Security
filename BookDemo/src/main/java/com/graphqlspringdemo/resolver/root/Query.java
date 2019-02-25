package com.graphqlspringdemo.resolver.root;


import java.util.List;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphqlspringdemo.model.JwtUser;
import com.graphqlspringdemo.pojo.Author;
import com.graphqlspringdemo.pojo.Post;
//import com.graphqlspringdemo.pojo.User;
import com.graphqlspringdemo.repository.AuthorRepository;
import com.graphqlspringdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.graphqlspringdemo.repository.PostRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/rest/graphql")
public class Query implements GraphQLRootResolver {


	public Query(PostRepository postRepository, AuthorRepository authRepo,UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.authRepo = authRepo;
		this.userRepository=userRepository;
	}
	@Autowired
	private  PostRepository postRepository;
	@Autowired
	private  AuthorRepository authRepo;
	@Autowired
	private UserRepository userRepository;


	@GetMapping("/getProlist")
	public List<Post> allOrders() {
		return postRepository.findAll();
	}

	@GetMapping("/list")
	public List<Author> allAuthors() {
		return authRepo.findAll();
	}

	public Author getAuthor(String Id){
		Author a = authRepo.findById(Id);
		return a;
	}

	public JwtUser loginUser(String userName){
		JwtUser dbUser=userRepository.findByUserName(userName);
//		System.out.println(dbUser.getName());
		return dbUser;
	}

	public List<JwtUser> allUsers() {
		return userRepository.findAll();
	}

}
