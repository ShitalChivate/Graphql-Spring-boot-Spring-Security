package com.graphqlspringdemo.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection="authors")
public class Author {

	@Id
	private  String id;
	private  String authorName;
	private String price;

	public Author(String id, String authorName, String price) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.price=price;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String name) {
		this.authorName = authorName;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof Author)) return false;
//		Author author = (Author) o;
//		return Objects.equals(getId(), author.getId()) &&
//				Objects.equals(getAuthorName(), author.getAuthorName()) &&
//				Objects.equals(getPrice(), author.getPrice());
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(getId(), getAuthorName(), getPrice());
//	}
}
