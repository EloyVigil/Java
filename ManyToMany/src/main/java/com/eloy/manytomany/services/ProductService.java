package com.eloy.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.manytomany.models.Category;
import com.eloy.manytomany.models.Product;
import com.eloy.manytomany.repositories.ProductRepository;

@Service
public class ProductService {

	// Adding repository dependecy
    @Autowired
    private ProductRepository productRepo;
    
	// Constructor
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	 //Create Product
	 public Product create(Product product) {
		 return productRepo.save(product);
		 }
    
	// Find one single product method
	public Product getOne(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	// Find one product by id
	 public Product findById(Long id) {
		 Optional<Product> optionalProduct = productRepo.findById(id);
		 if(optionalProduct.isPresent()) {
			 return optionalProduct.get();
		 } else {
			 return null;
		 }
	 }
	 
	 //find all products
	 public List<Product> allProduct() {
		 return productRepo.findAll();
	 }

	 //Update Product
	 public Product updateProduct(Product product) {
		 return productRepo.save(product);
		 }
		 
	 // Delete 
		 public void delete(Long id) {
			 productRepo.deleteById(id);
		 }

		 // Gets all assigned categories to product
		 public List<Product> getAssignedCategories(Category category){
			 return productRepo.findAllByCategories(category);
		 }
	
		 // Gets all unassigned categories to product
			public List<Product> getUnassignedCategories(Category category){
				return productRepo.findByCategoriesNotContains(category);
			}
		 
}
