package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Speciality;
import com.example.sangeepetclinic.repositories.SpecialtyRepository;
import com.example.sangeepetclinic.service.SpecialtyService;

@Service
public class SpecialitySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;
	
	
	public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Speciality save(Speciality type) {
		// TODO Auto-generated method stub
		return specialtyRepository.save(type);
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		Set<Speciality> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public void delete(Speciality speciality) {
		// TODO Auto-generated method stub
		specialtyRepository.delete(speciality);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		specialtyRepository.deleteById(id);
	}

}
