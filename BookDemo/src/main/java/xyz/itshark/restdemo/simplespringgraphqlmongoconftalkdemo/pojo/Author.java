package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
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

}
