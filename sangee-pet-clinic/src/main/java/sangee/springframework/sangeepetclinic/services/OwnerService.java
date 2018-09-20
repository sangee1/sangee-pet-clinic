package sangee.springframework.sangeepetclinic.services;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long Id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();

}
