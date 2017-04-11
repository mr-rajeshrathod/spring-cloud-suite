package com.cignex.book.catelog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.book.catelog.model.Book;
import com.cignex.book.catelog.service.BookCatelogService;

@RestController
public class BookController {

	@Autowired
	private BookCatelogService bookService;

	@RequestMapping(value = "/catelog/books/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Book> books() {
		return bookService.findBooks();
	}

	@RequestMapping(value = "/catelog/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Book book(@PathVariable String id) {
		return bookService.findBook(id);
	}

	@RequestMapping(value = "/catelog/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Book> getBooks(@RequestBody List<Book> bookIds) {
		return bookService.findBooks(bookIds);
	}

	@PostConstruct
	public void init() {

		if (bookService.findBooks().size() > 0) {
			return;
		}

		List<Book> books = new ArrayList<>();
		books.add(new Book(RandomUtils.nextLong() + "", "Head First JSP", "Learn Everything About JSP"));
		books.add(new Book(RandomUtils.nextLong() + "", "Head First SERVLET", "Learn Everything About SERVLET"));
		books.add(new Book(RandomUtils.nextLong() + "", "Head First Micro Services",
				"Learn Everything About MICRO SERVICES"));
		books.add(new Book(RandomUtils.nextLong() + "", "Head First Angular", "Learn Everything About ANGULAR"));

		bookService.saveBooks(books);
	}
}