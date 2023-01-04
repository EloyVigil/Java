package com.eloy.bookclub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.bookclub.models.User;

// Annotation always used in repository interface
@Repository
public interface UserRepository extends CrudRepository<User, Long> {      // Extending crud repository to utilize  
	
	// Finds all users in list
	List<User> findAll();
 
	// Find by email can also return null if needed
 Optional<User> findByEmail(String email);
 
}
