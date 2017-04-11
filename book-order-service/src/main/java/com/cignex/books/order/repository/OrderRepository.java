package com.cignex.books.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cignex.books.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, Long>{
}
