package com.example.sangeepetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sangeepetclinic.model.Visit;
import com.example.sangeepetclinic.repositories.VisitRepository;
import com.example.sangeepetclinic.service.VisitService;

@Service
public class VisitSDJpaService implements VisitService{

	private final VisitRepository visitRepository;
	
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit o) {
		// TODO Auto-generated method stub
		return visitRepository.save(o);
	}

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public void delete(Visit v) {
		// TODO Auto-generated method stub
		visitRepository.delete(v);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		visitRepository.deleteById(id);
		
	}

}
