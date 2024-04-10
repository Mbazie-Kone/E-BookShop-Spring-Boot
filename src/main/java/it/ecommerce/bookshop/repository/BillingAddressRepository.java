package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

}