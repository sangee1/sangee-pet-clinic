package com.example.sangeepetclinic.service;

import java.util.Set;

import com.example.sangeepetclinic.model.Pet;
import com.example.sangeepetclinic.model.PetType;
import com.example.sangeepetclinic.model.Speciality;

public interface SpecialtyService {
	Speciality findById(Long id);
	Speciality save(Speciality speciality);
	Set<Speciality> findAll();
	void delete(Speciality speciality);
	void deleteById(Long id);

}
