package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}