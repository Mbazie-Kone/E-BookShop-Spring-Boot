package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
