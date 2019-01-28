package com.graphql_spring_demo;

import com.graphql_spring_demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.graphql_spring_demo.repository.PostRepository;

@SpringBootApplication
public class SimpleSpringGraphqlMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringGraphqlMongoDemoApplication.class, args);
	}
	
	@Bean
	@Autowired
	public ServletRegistrationBean graphQLServlet(PostRepository postRepository, AuthorRepository authRepository ) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(postRepository, authRepository),"/graphql");
	}

}
