package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.services.PetService;

@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService{
	
	@Override
	public
	Set<Pet >findAll() {
	return super.findAll();
}
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Pet save(Pet o) {
		return super.save(o);
	}
	
	
	public void delete(Pet o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}

