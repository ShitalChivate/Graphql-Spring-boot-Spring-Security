//package com.graphqlspringdemo;
//
//import com.graphqlspringdemo.pojo.Author;
//import com.graphqlspringdemo.repository.AuthorRepository;
//import com.graphqlspringdemo.resolver.root.Mutation;
//import com.graphqlspringdemo.resolver.root.Query;
//import org.junit.Test;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.RunWith;
//import org.junit.runner.notification.Failure;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SimpleSpringGraphqlMongoDemoApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//	@Autowired
//	private Query query;
//
//	@InjectMocks
//	Mutation mutation;
//
//	@Mock
//	private AuthorRepository authorRepository;
//
//	@Test
//	public void saveUserTest() {
//		Author author = new Author("999", "Pranya",  "Pune");
//		Mockito.when(authorRepository.save((Author)anyObject())).thenReturn(author);
//		Mockito.when(mutation.addAuthor("999", "Pranya",  "Pune")).thenReturn(author);
//	}
//
//	@Test
//	public void deleteAuthorTest() {
//		System.out.println("inside deleteUserTEst");
//		Author user = new Author("999", "Pranya", "Pune");
//		mutation.deleteAuthor(user.getAuthorName());
//		verify(authorRepository, times(1)).delete(user.getAuthorName());
//	}
//	@Test
//	public void getAuthorTest() {
//		System.out.println("inside getUsersTest method");
//		when(authorRepository.findAll()).thenReturn(Stream
//				.of(new Author("1","london","UK"), new Author("958", "Huy",  "UK")).collect(Collectors.toList()));
//		assertEquals(2, query.allAuthors().size());
//	}
//
//	public static void main(String[] args) {
//		Result result = JUnitCore.runClasses(SimpleSpringGraphqlMongoDemoApplicationTests.class);
//
//		for (Failure failure : result.getFailures()) {
//			System.out.println(failure.toString());
//		}
//
//		System.out.println(result.wasSuccessful());
//	}
//
//}
