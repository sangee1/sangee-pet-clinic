package com.example.sangeepetclinic.service;

import java.util.Set;


import com.example.sangeepetclinic.model.Pet;

public interface PetService {

	
	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
