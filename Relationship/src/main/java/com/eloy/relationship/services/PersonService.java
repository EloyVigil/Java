package com.eloy.relationship.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eloy.relationship.models.Person;
import com.eloy.relationship.repositories.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public ArrayList<Person> allPerson(){
		return personRepo.findAll();
	}

	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }
	
    public void deletePeson(Long id) {
    	personRepo.deleteById(id);
    }

	public Person findById(Long person_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
