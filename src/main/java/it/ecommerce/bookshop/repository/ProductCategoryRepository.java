package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}