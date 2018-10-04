package sangee.springframework.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.sangeepetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
