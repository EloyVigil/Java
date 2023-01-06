package com.eloy.relationship.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.relationship.models.License;

@Repository
public interface LicenseRepo  extends CrudRepository<License, Long> {
	ArrayList<License> findAll();
}
