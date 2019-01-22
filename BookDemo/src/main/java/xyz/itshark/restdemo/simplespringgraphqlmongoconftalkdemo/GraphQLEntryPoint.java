package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.servlet.SimpleGraphQLServlet;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.AuthorResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.PostResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Mutation;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Query;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/rest/coffee")
//@RestController
public class GraphQLEntryPoint extends SimpleGraphQLServlet {

	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository ) {
		super(buildSchema(postRepository,authRepository));
	}
	private AuthorRepository authRepository;

	@NotNull
	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository ) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository,authRepository),
						new Mutation(authRepository,postRepository),
						new PostResolver(authRepository),
						new AuthorResolver(postRepository))
				.build()
				.makeExecutableSchema();
	}
}
