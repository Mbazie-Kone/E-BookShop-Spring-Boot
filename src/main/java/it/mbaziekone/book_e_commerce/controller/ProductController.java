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
	public String addProduct(@ModelAttribute("product") Product product, MultipartFile image, Model model){
		try {
			productService.saveProduct(product, image);
			model.addAttribute("message", "Product added");
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "Error!");
		}
		
		return "adminPortal";
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
