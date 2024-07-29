package it.mbaziekone.book_e_commerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import it.mbaziekone.book_e_commerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// behind the scenes, Spring will execute a query similar to this: SELECT * FROM product WHERE category_id = ?
	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
		
	Page<Product> findByNameContaining(@Param("name") String name, Pageable page);

}
