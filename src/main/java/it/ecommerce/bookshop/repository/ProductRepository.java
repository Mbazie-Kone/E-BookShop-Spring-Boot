package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
