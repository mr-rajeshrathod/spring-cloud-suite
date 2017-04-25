package com.cignex.shopping.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cignex.shopping.model.Order;

@FeignClient(name = "book-order-service", url = "http://localhost:8080/api", fallback = BookOrderClient.BookOrderClientFallback.class)
public interface BookOrderClient {
	@RequestMapping(value = "/cart/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Order placeOrder(@RequestBody Order order);

	@Component
	public static class BookOrderClientFallback implements BookOrderClient {

		@Override
		public Order placeOrder(@RequestBody Order order) {
			return new Order();
		}
	}
}
