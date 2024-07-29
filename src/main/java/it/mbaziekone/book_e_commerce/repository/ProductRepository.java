package it.mbaziekone.book_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mbaziekone.book_e_commerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
