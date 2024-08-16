package it.mbaziekone.book_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Controller
@RequestMapping("/adminPortal")
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
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "adminPortal/newProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		
		return "redirect:/adminPortal";
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
