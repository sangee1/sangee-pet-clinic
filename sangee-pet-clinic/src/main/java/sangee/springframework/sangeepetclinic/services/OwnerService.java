package sangee.springframework.sangeepetclinic.services;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
	
	Owner findByLastName(String lastName);
	
	
}
