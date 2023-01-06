package com.eloy.relationship.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.relationship.models.Person;


@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{
	
	ArrayList<Person> findAll();
}
