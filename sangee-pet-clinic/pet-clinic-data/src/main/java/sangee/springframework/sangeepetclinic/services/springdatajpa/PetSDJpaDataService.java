package sangee.springframework.sangeepetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.repositories.PetRepository;
import sangee.springframework.sangeepetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaDataService implements PetService{
	
	private final PetRepository petRepository;
	
	public PetSDJpaDataService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
		
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		petRepository.deleteById(id);
	}

}
