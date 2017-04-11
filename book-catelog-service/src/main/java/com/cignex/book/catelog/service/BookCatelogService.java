package com.cignex.book.catelog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cignex.book.catelog.model.Book;
import com.cignex.book.catelog.repository.BookRepository;

@Service
public class BookCatelogService {

	@Autowired
	private BookRepository repository;

	@Cacheable("books")
	public Book findBook(String bookId) {
		return repository.findOne(bookId);
	}
	
	public List<Book> findBooks(){
		return repository.findAll();
	}
	
	public List<Book> saveBooks(List<Book> books){
		return repository.save(books);
	}
	
	public Iterable<Book> findBooks(List<Book> books){
		List<String> bookIds = new ArrayList<>();
		books.forEach(b -> bookIds.add(b.getId()));
		return repository.findAll(bookIds);
	}
}
