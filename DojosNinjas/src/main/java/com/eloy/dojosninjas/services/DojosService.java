package com.eloy.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.dojosninjas.models.Dojo;
import com.eloy.dojosninjas.repositories.DojosRepository;


@Service
public class DojosService {
	
	@Autowired
	private DojosRepository dojosRepository;
	
	public DojosService(DojosRepository dojosRepository) {
		this.dojosRepository = dojosRepository;
	}
	
	// find all dojo findAll from repo
	public List<Dojo> allDojo(){
		return dojosRepository.findAll();
	}
	
	// create new dojo method
    public Dojo  create(Dojo dojo) {
        return dojosRepository.save(dojo);
    }
   
    // find dojo by id method
    public Dojo findById(Long id) {
        Optional<Dojo> optionalDojo = dojosRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    // update method save function
    public Dojo update(Dojo dojo) {
        return dojosRepository.save(dojo);
    }
    
    //delete by id method
    public void delete(Long id) {
    	dojosRepository.deleteById(id);
    }
	

}
