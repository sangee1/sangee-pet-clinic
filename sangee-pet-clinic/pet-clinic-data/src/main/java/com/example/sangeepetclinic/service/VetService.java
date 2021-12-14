package com.example.sangeepetclinic.service;

import java.util.Set;

import com.example.sangeepetclinic.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	Vet save(Vet o);
	Set<Vet> findAll();
	void delete(Vet v);
	void deleteById(Long id);
}
