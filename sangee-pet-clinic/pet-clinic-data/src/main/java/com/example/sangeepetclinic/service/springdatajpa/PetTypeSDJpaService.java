package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Pet;
import com.example.sangeepetclinic.model.PetType;
import com.example.sangeepetclinic.repositories.PetTypeRepository;
import com.example.sangeepetclinic.service.PetTypeService;

@Service
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	
	
	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType type) {
		// TODO Auto-generated method stub
		return petTypeRepository.save(type);
	}

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType p) {
		// TODO Auto-generated method stub
		petTypeRepository.delete(p);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		petTypeRepository.deleteById(id);
		
	}

}
