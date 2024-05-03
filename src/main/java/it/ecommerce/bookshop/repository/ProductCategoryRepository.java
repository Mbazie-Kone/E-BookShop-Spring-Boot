package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductRepository, Long> {

}