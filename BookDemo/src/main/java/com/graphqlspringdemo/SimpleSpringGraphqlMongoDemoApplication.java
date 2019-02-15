package com.graphqlspringdemo;

import com.graphqlspringdemo.repository.AuthorRepository;
import com.graphqlspringdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.graphqlspringdemo.repository.PostRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@SpringBootApplication
public class SimpleSpringGraphqlMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringGraphqlMongoDemoApplication.class, args);
	}

	@Bean
	@Autowired
	public ServletRegistrationBean graphQLServlet(PostRepository postRepository, AuthorRepository authRepository, UserRepository userRepository ) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(postRepository, authRepository,userRepository),"/graphql");
	}

}
