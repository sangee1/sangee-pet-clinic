package sangee.springframework.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.sangeepetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
