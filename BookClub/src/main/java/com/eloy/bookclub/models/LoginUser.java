package com.eloy.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// No annotations because this model is temporary only for logging in 
public class LoginUser {
  
  @NotEmpty(message="Email is required!")
  @Email(message="Please enter a valid email!")
  private String email;
  
  @NotEmpty(message="Password is required!")
  @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
  private String password;
  
  public LoginUser() {}

  // Overload constructor
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
  
	
  
  
  
}
