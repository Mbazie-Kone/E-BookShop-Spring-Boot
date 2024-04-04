package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUserName(String userName);
	
	public User findByEmail(String email);
}