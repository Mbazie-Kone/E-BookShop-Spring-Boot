package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	

}
