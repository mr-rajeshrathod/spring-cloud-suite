package com.cignex.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cignex.shopping.model.UserCart;

public interface ShoppingRepository extends MongoRepository<UserCart, String> {
	public UserCart findByToken(String token);
}