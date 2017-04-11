package com.cignex.books.order.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users_cart")
public class UserCart {

	@Id
	private String id;

	@Field
	private String token;

	@Field
	private List<String> books;
	
	public UserCart() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}
}
