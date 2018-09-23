package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;


import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long>{
	
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
		return super.save(o.getId(),o);
	}
	
	
	public void delete(Pet o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}

