package com.example.sangeepetclinic.service;

import java.util.Set;

import com.example.sangeepetclinic.model.Visit;

public interface VisitService {
	Visit findById(Long id);
	Visit save(Visit o);
	Set<Visit> findAll();
	void delete(Visit v);
	void deleteById(Long id);

}
