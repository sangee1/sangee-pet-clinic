package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Pet;
import com.example.sangeepetclinic.repositories.PetRepository;
import com.example.sangeepetclinic.service.PetService;

@Service
public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet pet) {
		
		return petRepository.save(pet);
	}

	@Override
	public Set<Pet> findAll() {
		
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet pet) {
		petRepository.delete(pet);
		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
		
	}

}
