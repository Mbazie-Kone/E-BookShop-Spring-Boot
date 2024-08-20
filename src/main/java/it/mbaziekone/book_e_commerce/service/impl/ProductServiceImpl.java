package it.mbaziekone.book_e_commerce.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.model.dto.ProductDto;
import it.mbaziekone.book_e_commerce.repository.ProductRepository;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final String UPLOAD_DIR = "front-end/src/assets/images/";
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllCatalogs() {
		return productRepository.findAll();
	}
	
	public void saveProduct(Product product, MultipartFile image) throws IOException {
		
		File uploadDir = new File(UPLOAD_DIR);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		String originalFileName = image.getOriginalFilename();
		String filePath = UPLOAD_DIR + originalFileName;
		Path path = Paths.get(filePath);
		Files.write(path, image.getBytes());
		
		ProductDto productDto = new ProductDto();
		
		product.setSku(productDto.getSku());
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setUnitPrice(productDto.getUnitPrice());
		product.setImageUrl("/assets/images" + originalFileName);
		product.setUnitPrice(productDto.getUnitPrice());
		product.setActive(productDto.isActive());
		product.setUnitsInStock(productDto.getUnitsInStock());
		product.setDateCreated(productDto.getDateCreate());
		product.setLastUpdate(productDto.getLastUpdate());
		product.setCategory(productDto.getCategory());
		
		productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Product not found for ID :: " + id));
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);	
	}
}
