package com.eloy.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.dojosninjas.models.Ninja;
import com.eloy.dojosninjas.repositories.NinjasRepository;

@Service
public class NinjasService {
	
	@Autowired
	private  NinjasRepository ninjasRepository;
	
	public NinjasService(NinjasRepository ninjasRepository) {
		this.ninjasRepository = ninjasRepository;
	}
	
	// find all ninja findAll from repo
	public List<Ninja> allNinja(){
		return ninjasRepository.findAll();
	}
	
	// create new ninja method
    public Ninja create(Ninja ninja) {
        return ninjasRepository.save(ninja);
    }
    
    // find ninja by id method
    public Ninja findById(Long id) {
        Optional<Ninja> optionalNinja = ninjasRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    // update method save function
    public Ninja update(Ninja ninja) {
        return ninjasRepository.save(ninja);
    }
    
    //delete by id method
    public void delete(Long id) {
    	ninjasRepository.deleteById(id);
    }
	
}
