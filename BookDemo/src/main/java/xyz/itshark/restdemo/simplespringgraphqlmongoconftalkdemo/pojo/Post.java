package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="posts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

	@Id
	private  String id;

	@NotNull
	private String authorId;
	private String orderProceed;
	private  String price;
	private  String quantity;


	public Post(String authorId , String quantity) {
		super();
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return price;
	}
	public void setTitle(String price) {
		this.price = price;
	}

	public String getOrderProceed() {
		return orderProceed;
	}

	public void setOrderProceed(String orderProceed) {
		this.orderProceed = orderProceed;
	}

}
