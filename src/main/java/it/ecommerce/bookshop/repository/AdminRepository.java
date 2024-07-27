package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.security.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {

}
