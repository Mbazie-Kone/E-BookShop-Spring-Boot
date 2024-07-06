package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.ecommerce.bookshop.model.State;

@CrossOrigin("http://localhost:4200")
public interface StateRepository extends JpaRepository<State, Long>{

}
