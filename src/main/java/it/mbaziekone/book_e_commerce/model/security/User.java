package it.mbaziekone.book_e_commerce.model.security;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

}
