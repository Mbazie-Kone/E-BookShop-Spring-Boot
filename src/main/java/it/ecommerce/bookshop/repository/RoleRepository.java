package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}