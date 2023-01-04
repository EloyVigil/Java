package com.caresoft.clinicapp;

// member attributes/variables 
public class User {
	protected Integer id;
    protected int pin;
    
//    constructor
    public User(Integer id, int pin) {
    	this.id = id;
    	this.pin = pin;
    }
//  constructor
    public User(Integer id) {
  	    this.id = id;
  }
	    
//    getter method
    public Integer getUserId() {
    	return id;
    }
    
//    setter method
    public void setUserPin(int pin) {
    	this.pin = pin;
    }
    
    public void setUserId(Integer id) {
    	this.id = id;
    }
    
}
