package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root;


import java.util.List;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RestController
@RequestMapping("/rest/graphql")
public class Query implements GraphQLRootResolver {

	public Query(PostRepository postRepository, AuthorRepository authRepo) {
		super();
		this.postRepository = postRepository;
		this.authRepo = authRepo;
	}
	@Autowired
	private  PostRepository postRepository;
	@Autowired
	private  AuthorRepository authRepo;

	@GetMapping("/getProlist")
    public List<Post> allOrders() {
        return postRepository.findAll();
    }

	@GetMapping("/list")
    public List<Author> allAuthors() {
        List<Author> list = authRepo.findAll();
        for(Author a: list){
            System.out.println(a.getAuthorName());
        }
    		return authRepo.findAll();
    }


	public Author getAuthor(String Id){
	    Author a = authRepo.findById(Id);
		return a;}

}
