package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}