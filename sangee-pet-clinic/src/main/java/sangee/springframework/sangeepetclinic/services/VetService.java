package sangee.springframework.sangeepetclinic.services;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Vet;

public interface VetService {
	Vet findById(Long Id);
	
	Vet save(Vet owner);
	
	Set<Vet> findAll();

}
