package it.mbaziekone.book_e_commerce.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class ProductDto {
	
	private String sku;
	
	@NotEmpty(message = "The name is required")
	private String name;
	
	private String description;
	
	@NotEmpty(message = "The unit price is required")
	private BigDecimal unitPrice;
	
	@NotEmpty(message = "The active data is required")
	private boolean active;
	
	@NotEmpty(message = "The units in stock data is required")
	private int unitsInStock;
	
	private Date dateCreate;
	
	private Date lastUpdate;
	
	@NotEmpty(message = "The product category is required")
	private int category;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
