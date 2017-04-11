package com.cignex.books.order.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "orders")
public class Order {

	@Id
	private long orderId;
	
	@Field
	private long userId;
	
	@Field
	private List<String> books;
	
	@Field
	private Date orderDate;
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}
}
