package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
