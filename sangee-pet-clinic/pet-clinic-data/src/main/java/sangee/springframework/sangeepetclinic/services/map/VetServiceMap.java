package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Vet;
import sangee.springframework.sangeepetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService{
	
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
		return super.save(o);
	}
	
	
	public void delete(Vet o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}

