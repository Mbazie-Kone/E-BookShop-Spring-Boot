package it.mbaziekone.book_e_commerce.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.model.dto.ProductDto;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Controller
@RequestMapping("/dashboard")
public class ProductController {
	
	private static final String UPLOAD_DIR = "front-end/src/assets/images/";
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String viewProductsPage(Model model) {
		model.addAttribute("listProducts", productService.getAllCatalogs());
		
		return "adminPortal"; //This is the view that contains the dashboard layout
	}
	
	@GetMapping("/showNewCatalogForm")
	public String showProductForm(Model model) {
		ProductDto productDto = new ProductDto();
		model.addAttribute("productDto", productDto);
		
		return "addProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("productDto") ProductDto productDto, MultipartFile image) throws IOException {
		File uploadDir = new File(UPLOAD_DIR);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		String originalFileName = image.getOriginalFilename();
		String filePath = UPLOAD_DIR + originalFileName;
		Path path = Paths.get(filePath);
		Files.write(path, image.getBytes());
		
		Product product = new Product();
		
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
		
		productService.saveProduct(product);
		
		return "redirect:/dashboard/adminPortal";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "adminPortal/updateProduct";	
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") long id) {
		productService.deleteProduct(id);
		
		return "redirect:/adminPortal";
	}
}
