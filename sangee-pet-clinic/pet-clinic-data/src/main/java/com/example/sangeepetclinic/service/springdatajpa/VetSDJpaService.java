package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Vet;
import com.example.sangeepetclinic.repositories.VetRepository;
import com.example.sangeepetclinic.service.VetService;

@Service
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet o) {
		// TODO Auto-generated method stub
		return vetRepository.save(o);
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet v) {
		// TODO Auto-generated method stub
		vetRepository.delete(v);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		vetRepository.deleteById(id);

	}

}
