package com.ecommerce.ecom.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecom.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	
}
