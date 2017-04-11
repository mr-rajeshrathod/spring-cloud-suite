package com.cignex.shopping.model;

import java.util.Date;
import java.util.List;

public class Order {

	private long orderId;
	private long userId;
	private List<String> books;
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
