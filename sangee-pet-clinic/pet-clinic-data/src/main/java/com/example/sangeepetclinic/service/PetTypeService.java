package com.example.sangeepetclinic.service;

import java.util.Set;

import com.example.sangeepetclinic.model.Pet;
import com.example.sangeepetclinic.model.PetType;

public interface PetTypeService {
	PetType findById(Long id);
	PetType save(PetType type);
	Set<PetType> findAll();
	void delete(PetType p);
	void deleteById(Long id);
}
