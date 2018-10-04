package sangee.springframework.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.sangeepetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
