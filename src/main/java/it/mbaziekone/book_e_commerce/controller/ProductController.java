package it.mbaziekone.book_e_commerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String viewProductsPage(Model model) {
		model.addAttribute("listProducts", productService.getAllCatalogs());
		
		return "adminPortal"; //This is the view that contains the dashboard layout
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
		
		return "redirect:/dashboard";
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
		
		return "redirect:/dashboard";
	}
	
	// Delete product
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") long id) {
		productService.deleteProduct(id);
		
		return "redirect:/dashboard";
	}
}
