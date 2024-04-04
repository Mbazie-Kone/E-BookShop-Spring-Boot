package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {

}