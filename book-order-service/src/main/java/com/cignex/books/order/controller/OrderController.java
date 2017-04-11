package com.cignex.books.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.books.order.model.Order;
import com.cignex.books.order.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository repository;

	@RequestMapping(value = "/cart/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Order placeOrder(@RequestBody Order order) {
		return repository.save(order);
	}
}