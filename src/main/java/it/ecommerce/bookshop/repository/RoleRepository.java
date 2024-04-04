package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.security.Role;
import java.util.List;


public interface RoleRepository extends CrudRepository<Role, Long> {
	
	public List<Role> findByName(String name);
	
}