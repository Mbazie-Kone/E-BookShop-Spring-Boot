package it.mbaziekone.book_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mbaziekone.book_e_commerce.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
