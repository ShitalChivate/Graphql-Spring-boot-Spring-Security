package com.graphql_spring_demo;

import com.coxautodev.graphql.tools.SchemaParser;
import com.graphql_spring_demo.repository.AuthorRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import org.jetbrains.annotations.NotNull;
import com.graphql_spring_demo.repository.PostRepository;
import com.graphql_spring_demo.resolver.ql.AuthorResolver;
import com.graphql_spring_demo.resolver.ql.PostResolver;
import com.graphql_spring_demo.resolver.root.Mutation;
import com.graphql_spring_demo.resolver.root.Query;


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
