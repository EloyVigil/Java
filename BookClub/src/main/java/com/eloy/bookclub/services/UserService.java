package com.eloy.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.eloy.bookclub.models.LoginUser;
import com.eloy.bookclub.models.User;
import com.eloy.bookclub.repository.UserRepository;

@Service
public class UserService {

	// Adding dependecy from user repository
	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		// checks if User email is already in db 
		Optional<User> userObject = userRepo.findByEmail(newUser.getEmail());
		// Displays errors if already in db
		if (userObject.isPresent()) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}
		// checks if in password matches
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		// validation errors
		if (result.hasErrors()) {
			return null;
		}
		// hashing password and saving user and hashed password
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// Sets password to hashed password
		newUser.setPassword(hashed);
		//Saves user after passing all validations
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		// checking if email is in database if not display errors
		Optional<User> userObject = userRepo.findByEmail(newLoginObject.getEmail());
		// if not in db display errors
		if (!userObject.isPresent()) {
			result.rejectValue("email", "Matches", "Invalid Username/Password");
			return null;
		}
		// checking if hashed password matches password entered at login
		User user = userObject.get();
		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			// display errors if no match
			result.rejectValue("password", "Unique", "Invalid Username/Password");
		}
		// validation errors
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}

	// Finds User by id in db
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	// Gets one user
	public User getUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	//Updates user if needed
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	// Deletes user if needed
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
