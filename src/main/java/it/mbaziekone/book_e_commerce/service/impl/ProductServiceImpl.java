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
		
		product.setSku(product.getSku());
		product.setName(product.getName());
		product.setDescription(product.getDescription());
		product.setUnitPrice(product.getUnitPrice());
		product.setImagePath("images/" + uniqueFileName);
		product.setActive(product.isActive());
		product.setUnitsInStock(product.getUnitsInStock());
		product.setDateCreated(product.getDateCreated());
		product.setLastUpdate(product.getLastUpdate());
		product.setCategory(product.getCategory());
		
		productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Product not found for ID :: " + id));
	}
	
	public void deleteProduct(Long id) {
		
		Product product = getProductById(id);
		String imagePath = product.getImagePath();
		Path path = Paths.get(UPLOAD_DIR + imagePath.replace("images/", ""));
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		productRepository.deleteById(id);
	}
}
