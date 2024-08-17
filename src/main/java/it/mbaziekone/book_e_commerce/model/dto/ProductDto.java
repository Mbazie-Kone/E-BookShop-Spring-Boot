package it.mbaziekone.book_e_commerce.model.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class ProductDto {
	
	private String sku;
	
	@NotEmpty(message = "The name is required")
	private String name;
	
	private String description;
	
	private BigDecimal unitPrice;
	
	private MultipartFile imageFilename;
	
	@NotEmpty(message = "The active data is required")
	private boolean active;
	
	
}
