package sangee.springframework.sangeepetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Vet;
import sangee.springframework.sangeepetclinic.repositories.VetRepository;
import sangee.springframework.sangeepetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
	
	private final VetRepository vetRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vetSet = new HashSet<>();
		vetRepository.findAll().forEach(vetSet::add);;
		return vetSet;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		vetRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		vetRepository.deleteById(id);
		
	}
	

}
