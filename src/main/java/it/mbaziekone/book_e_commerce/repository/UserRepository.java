package it.mbaziekone.book_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mbaziekone.book_e_commerce.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
