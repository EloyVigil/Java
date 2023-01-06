package com.eloy.savetravels.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.eloy.savetravels.models.Travel;
import com.eloy.savetravels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	public ArrayList<Travel> allTravel(){
		return travelRepository.findAll();
	}
	
    public Travel createTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
    public Travel updateTravel(Travel travel) {
        return travelRepository.save(travel);
    }
	
    public void deleteTravel(Long id) {
    	travelRepository.deleteById(id);
    }
	
	
	
}
