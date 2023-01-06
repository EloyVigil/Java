package com.eloy.relationship.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.eloy.relationship.models.License;
import com.eloy.relationship.repositories.LicenseRepo;

@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public ArrayList<License> allLicense(){
		return licenseRepo.findAll();
	}
	
	public License createLicense(License license) {
		return licenseRepo.save(license);
	}
	
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

    public License updateLicense(License license) {
        return licenseRepo.save(license);
    }
	
    public void deletLicense(Long id) {
    	licenseRepo.deleteById(id);
    }
	
	
}
