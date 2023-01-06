package com.eloy.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.manytomany.models.Category;
import com.eloy.manytomany.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
 
	List<Product> findAll();
	
	
	// Retrieves a list of all product for a particular product
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any product a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
    
    
}
