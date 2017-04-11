package com.cignex.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.shopping.model.Book;
import com.cignex.shopping.model.Order;
import com.cignex.shopping.model.UserCart;
import com.cignex.shopping.service.ShoppingService;

@RestController
public class ShoppingController {

	@Autowired
	private ShoppingService service;

	@RequestMapping(value = "/shopping/version")
	public String getVersion() {
		return "1.0";
	}

	@RequestMapping(value = "/cart/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Book> getCart(@RequestHeader String token) {
		return service.getCart(token);
	}

	@RequestMapping(value = "/cart/addItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserCart addBookToCart(@RequestBody List<Book> bookIds, @RequestHeader String token) {
		return service.addBookToCart(token, bookIds);
	}

	@RequestMapping(value = "/cart/checkout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Order checkout(@RequestHeader String token) {
		return service.placeOrder(token);
	}
}