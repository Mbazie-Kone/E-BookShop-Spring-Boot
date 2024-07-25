package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.ecommerce.bookshop.model.security.Admin;

@CrossOrigin()
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
