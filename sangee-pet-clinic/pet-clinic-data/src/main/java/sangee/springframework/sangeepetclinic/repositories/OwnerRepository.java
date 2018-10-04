package sangee.springframework.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.sangeepetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);

}
