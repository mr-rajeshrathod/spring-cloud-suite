package com.cignex.shopping.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.shopping.client.BookCatelogClient;
import com.cignex.shopping.client.BookOrderClient;
import com.cignex.shopping.model.Book;
import com.cignex.shopping.model.Order;
import com.cignex.shopping.model.UserCart;
import com.cignex.shopping.repository.ShoppingRepository;

@Service
public class ShoppingService {

	private static final Logger log = LoggerFactory.getLogger(ShoppingService.class);

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

		log.debug("addBookToCart(), token:" + token);

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

	public Iterable<Book> getCart(String token) {

		UserCart cart = repository.findByToken(token);
		List<Book> bookIds = new ArrayList<>();

		cart.getBooks().forEach(b -> bookIds.add(new Book(b)));

		log.debug("getCart() with bookId " + bookIds);
		return bookCatelogClient.getBooks(bookIds);
	}

	/**
	 * 
	 * @param token
	 * @return Order
	 */
	public Order placeOrder(String token) {

		Order order = new Order();

		UserCart cart = repository.findByToken(token);
		order.setBooks(cart.getBooks());
		order.setOrderDate(new Date());

		return bookOrderClient.placeOrder(order);
	}
}
