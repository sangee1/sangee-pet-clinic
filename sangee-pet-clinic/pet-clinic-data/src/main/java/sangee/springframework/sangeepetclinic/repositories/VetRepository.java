package sangee.springframework.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.sangeepetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
