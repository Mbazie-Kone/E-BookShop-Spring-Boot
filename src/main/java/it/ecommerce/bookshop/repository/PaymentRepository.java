package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}