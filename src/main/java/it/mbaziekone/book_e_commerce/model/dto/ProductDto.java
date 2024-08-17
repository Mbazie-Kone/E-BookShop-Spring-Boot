package it.mbaziekone.book_e_commerce.model.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	
	private String sku;
	
	private String name;
	
	private String description;
	
	private BigDecimal unitPrice;
	
	private MultipartFile imageFilename;
}
