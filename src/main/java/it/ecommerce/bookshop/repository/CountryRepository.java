package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
