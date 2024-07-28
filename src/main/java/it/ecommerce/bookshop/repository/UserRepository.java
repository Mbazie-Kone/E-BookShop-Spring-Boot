package it.ecommerce.bookshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.security.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
}
