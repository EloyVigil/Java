package com.eloy.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.manytomany.models.Category;
import com.eloy.manytomany.models.Product;
import com.eloy.manytomany.repositories.CategoryRepository;

@Service
public class CategoryService {
   
	// Adding repository dependecy
	@Autowired
	private CategoryRepository categoryRepo;
	
	// Constructor
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	

	 //Create Category
	 public Category create(Category category) {
		 return categoryRepo.save(category);
		 }
	
	// Find one single category method
	public Category getOne(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	
	// Find one category by id
	 public Category findById(Long id) {
		 Optional<Category> optionalCategory = categoryRepo.findById(id);
		 if(optionalCategory.isPresent()) {
			 return optionalCategory.get();
		 } else {
			 return null;
		 }
	 }
	
	 //find all categories
	 public List<Category> allCategory() {
		 return categoryRepo.findAll();
	 }
	 
	 //Update Category
	 public Category updateCategory(Category category) {
		 return categoryRepo.save(category);
		 }
		 
	 // Delete 
		 public void delete(Long id) {
			 categoryRepo.deleteById(id);
		 }
		 
		public List<Category> getAssignedProducts(Product product){
			return categoryRepo.findAllByProducts(product);
		}
		
		public List<Category> getUnassignedProducts(Product product){
			return categoryRepo.findByProductsNotContains(product);
		}
		
	 
	 
}
