package com.cignex.book.catelog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cignex.book.catelog.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}
