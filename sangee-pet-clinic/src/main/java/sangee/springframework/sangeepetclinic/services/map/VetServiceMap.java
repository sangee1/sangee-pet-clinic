package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Vet;
import sangee.springframework.sangeepetclinic.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long>{
	
	@Override
	public
	Set<Vet >findAll() {
	return super.findAll();
}
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Vet save(Vet o) {
		return super.save(o.getId(),o);
	}
	
	
	public void delete(Vet o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}

