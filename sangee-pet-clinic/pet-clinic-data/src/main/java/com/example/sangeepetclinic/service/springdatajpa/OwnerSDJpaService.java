package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Owner;
import com.example.sangeepetclinic.repositories.OwnerRepository;
import com.example.sangeepetclinic.repositories.PetRepository;
import com.example.sangeepetclinic.repositories.PetTypeRepository;
import com.example.sangeepetclinic.service.OwnerService;

@Service
public class OwnerSDJpaService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Owner> ownerOptional =  ownerRepository.findById(id);
		return ownerOptional.orElse(null);
	};

	@Override
	public Owner save(Owner o) {
		// TODO Auto-generated method stub
		return ownerRepository.save(o);
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner o) {
		// TODO Auto-generated method stub
		ownerRepository.delete(o);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ownerRepository.deleteById(id);
		
	}

}
