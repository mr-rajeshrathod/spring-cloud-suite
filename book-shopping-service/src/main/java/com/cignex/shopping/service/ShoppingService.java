package com.cignex.shopping.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.shopping.client.BookCatelogClient;
import com.cignex.shopping.client.BookOrderClient;
import com.cignex.shopping.model.Book;
import com.cignex.shopping.model.Order;
import com.cignex.shopping.model.UserCart;
import com.cignex.shopping.repository.ShoppingRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingRepository repository;

	@Autowired
	private BookCatelogClient bookCatelogClient;

	@Autowired
	private BookOrderClient bookOrderClient;

	/**
	 * 
	 * @param token
	 * @param bookIds
	 * @return UserCart
	 */
	public UserCart addBookToCart(String token, List<Book> books) {

		List<String> bookIds = new ArrayList<>();

		UserCart cart = repository.findByToken(token);

		if (cart == null) {
			cart = new UserCart();
			cart.setToken(token);
			cart.setBooks(new ArrayList<>());
		}

		books.forEach(b -> bookIds.add(b.getId()));
		cart.getBooks().addAll(bookIds);

		return repository.save(cart);
	}

	@HystrixCommand(fallbackMethod = "bookNotFound")
	public Iterable<Book> getCart(String token) {

		UserCart cart = repository.findByToken(token);
		List<Book> bookIds = new ArrayList<>();
		
		cart.getBooks().forEach(b -> bookIds.add(new Book(b)));
		
		return bookCatelogClient.getBooks(bookIds);
	}

	/**
	 * 
	 * @param token
	 * @return Order
	 */
	@HystrixCommand(fallbackMethod = "orderServiceDown")
	public Order placeOrder(String token) {

		Order order = new Order();

		UserCart cart = repository.findByToken(token);
		order.setBooks(cart.getBooks());
		order.setOrderDate(new Date());

		return bookOrderClient.placeOrder(order);
	}
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	public Iterable<Book> bookNotFound(String token) {
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	public Order orderServiceDown(String token) {
		return new Order();
	}
}
