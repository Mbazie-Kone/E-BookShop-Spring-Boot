package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.security.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}