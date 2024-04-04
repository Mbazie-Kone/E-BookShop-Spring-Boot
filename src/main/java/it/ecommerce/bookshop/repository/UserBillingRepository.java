package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.UserBilling;

public interface UserBillingRepository extends CrudRepository<UserBilling, Long> {

}