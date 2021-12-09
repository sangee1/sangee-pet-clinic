package com.example.sangeepetclinic.service;

import java.util.Set;

import com.example.sangeepetclinic.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	Owner findById(Long id);
	Owner save(Owner o);
	Set<Owner> findAll();

}