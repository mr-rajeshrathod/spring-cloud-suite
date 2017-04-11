package com.cignex.shopping.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cignex.shopping.model.Book;

@FeignClient("http://book-catelog-service")
public interface BookCatelogClient {

	@RequestMapping(value = "/catalog/books/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Book getBook(@PathVariable("bookId") String bookId);

	@RequestMapping(value = "/catalog/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Iterable<Book> getBooks(@RequestBody List<Book> books);
}
