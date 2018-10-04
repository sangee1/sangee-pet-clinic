package sangee.springframework.sangeepetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.PetType;
import sangee.springframework.sangeepetclinic.repositories.PetTypeRepository;
import sangee.springframework.sangeepetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaDataService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	
	public PetTypeSDJpaDataService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		petTypeRepository.deleteById(id);
		
	}

}
