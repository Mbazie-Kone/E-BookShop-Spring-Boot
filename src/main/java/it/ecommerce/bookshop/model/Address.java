package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

}
