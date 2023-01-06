package com.eloy.manytomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eloy.manytomany.models.Category;
import com.eloy.manytomany.models.Product;
import com.eloy.manytomany.services.CategoryService;
import com.eloy.manytomany.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	
	// Main page display
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productServ.allProduct();
		List<Category> categories = categoryServ.allCategory();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "home.jsp";
	}
	
	//Display new product form
	@GetMapping("/new/product")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	// PostMapping for creating new product
	@PostMapping("/new/product")
	public String addProduct(@Valid @ModelAttribute("product") Product product) {
		productServ.create(product);
		return "redirect:/";
	}
	
	//Display the individual product by id 
	@GetMapping("/view/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productServ.findById(id);
		model.addAttribute("assignedCategories", categoryServ.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryServ.getUnassignedProducts(product));
		model.addAttribute("product", product);
		return "showProduct.jsp";
	}
	
	//Post the individual product by id to a category
	@PostMapping("/product/{id}")
	public String editProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
		Product product = productServ.findById(id);
		Category category = categoryServ.findById(categoryId);
		product.getCategories().add(category);
		productServ.updateProduct(product);
		model.addAttribute("assignedCategories", categoryServ.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryServ.getUnassignedProducts(product));
		return "redirect:/view/product/{id}";
	}
	
	// Display the new category form
	@GetMapping("/new/category")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "newCategory.jsp";
	}
	
	// Post the data from form about new category
	@PostMapping("/new/category")
	public String postNewCategory(@Valid @ModelAttribute("category") Category category, Model model) {
		categoryServ.create(category);
		return "redirect:/";
	}
	
	//Display the individual category by id 
	@GetMapping("/view/{id}/category")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryServ.findById(id);
		model.addAttribute("assignedProducts", productServ.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productServ.getUnassignedCategories(category));
		model.addAttribute("category", categoryServ.findById(id));
		return "showCategory.jsp";
}
	
	//Post the individual category by id to a product
	@PostMapping("/view/{id}/category")
	public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		Category category = categoryServ.findById(id);
		Product product = productServ.findById(productId);
		category.getProducts().add(product);
		categoryServ.updateCategory(category);
		model.addAttribute("assignedProducts", productServ.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productServ.getUnassignedCategories(category));
		return "redirect:/view/{id}/category";
	}

	
}
