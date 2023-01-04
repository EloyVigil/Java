package com.caresoft.clinicapp;

import java.util.*;

public class AdminUser extends User implements HIPAAComplaintUser, HIPAAComplaintAdmin {
	

//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.role = role;
    	this.securityIncidents = new ArrayList<String>();
    	// TODO Auto-generated constructor stub
    }
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
 
    // TO DO: Setters & Getters
    
//    getter method
	public Integer getEmployeeID() {
		return employeeID;
	}
	
//	setter method
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
//	getter method
	public String getRole() {
		return role;
	}
	
//	setter method
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
	// TODO Auto-generated method stub
		if (pin < 99999 || pin > 999999) {
			return false;
		}
		else {
			this.pin = pin;
			return true;
		}
}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
	// TODO Auto-generated method stub
		if (confirmedAuthID != this.id) {
			this.authIncident();
			return false;
		}
		else {
			return true;
		}
}
    

}
