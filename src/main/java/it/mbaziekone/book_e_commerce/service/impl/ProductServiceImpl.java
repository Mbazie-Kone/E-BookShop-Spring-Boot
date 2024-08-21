package it.mbaziekone.book_e_commerce.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.repository.ProductRepository;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final String UPLOAD_DIR = "/src/main/resources/static/images/";
	
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
		String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;
		String filePath = UPLOAD_DIR + uniqueFileName;
		Path path = Paths.get(filePath);
		Files.write(path, image.getBytes());
		
		Product productTwo = new Product();
		
		productTwo.setSku(product.getSku());
		productTwo.setName(product.getName());
		productTwo.setDescription(product.getDescription());
		productTwo.setUnitPrice(product.getUnitPrice());
		product.setImagePath("images/" + uniqueFileName);
		productTwo.setActive(product.isActive());
		productTwo.setUnitsInStock(product.getUnitsInStock());
		productTwo.setDateCreated(product.getDateCreated());
		productTwo.setLastUpdate(product.getLastUpdate());
		productTwo.setCategory(product.getCategory());
		
		productRepository.save(productTwo);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Product not found for ID :: " + id));
	}
	
	public void deleteProduct(Long id) {
		
		Product product = getProductById(id);
		String imagePath = product.getImagePath();
		Path path = Paths.get(UPLOAD_DIR + imagePath);
		
		productRepository.deleteById(id);	
	}
}
