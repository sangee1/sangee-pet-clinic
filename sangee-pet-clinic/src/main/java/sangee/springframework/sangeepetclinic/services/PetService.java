package sangee.springframework.sangeepetclinic.services;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long Id);
	
	Pet save(Pet owner);
	
	Set<Pet> findAll();

}
