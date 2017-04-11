package com.cignex.shopping.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cignex.shopping.model.Order;

@FeignClient("book-order-service")
public interface BookOrderClient {
	@RequestMapping(value = "/cart/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Order placeOrder(@RequestBody Order order);
}
