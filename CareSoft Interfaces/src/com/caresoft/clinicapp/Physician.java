package com.caresoft.clinicapp;

import java.util.*;

public class Physician extends User implements HIPAAComplaintUser {
		// TODO Auto-generated constructor stub

//... imports class definition...

	// Inside class:

	// TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
	}
	
	private ArrayList<String> patientNotes;
	// TO DO: Implement HIPAACompliantUser!

	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin < 999 || pin > 9999) {
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
		if (this.id == confirmedAuthID) {
			return true;
		}
		else {
			return false;	
		}
	}

	// TO DO: Setters & Getters
//	getter method
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

//	
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


}
