package it.mbaziekone.book_e_commerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// Show products
	@GetMapping("/products")
	public String viewProductsPage(
			@RequestParam(defaultValue = "0") int page, // Current page (default the first page)
			@RequestParam(defaultValue = "4") int size, // Number of elements per page (default 4)
			Model model) {
		
		Page<Product> productPage = productService.getPaginatedProducts(page, size);
		
		model.addAttribute("productPage", productPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", productPage.getTotalPages());
		
		return "productsAdmin"; //This is the view that contains the products table layout
	}
	
	// Insert product
	@GetMapping("/showNewCatalogForm")
	public String showProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@PostMapping("/saveProduct")
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile image, Model model){
		
		try {
			productService.saveProduct(product, image);
			model.addAttribute("message", "Product added successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "Error saving the product!");
			
			return "addProduct";
		}
		
		return "redirect:/productsAdmin";
	}
	
	// Update product
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "updateProduct";	
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile image, Model model) {
		
		try {
			productService.saveProduct(product, image);
			model.addAttribute("message", "Product updated successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "Error updating product!");
			
			return "updateProduct";
		}
		
		return "redirect:/productsAdmin";
	}
	
	// Delete product
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") long id) {
		productService.deleteProduct(id);
		
		return "redirect:/productsAdmin";
	}
}
