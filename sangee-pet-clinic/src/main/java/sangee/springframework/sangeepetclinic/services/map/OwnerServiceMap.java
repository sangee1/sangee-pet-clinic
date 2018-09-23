package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long>{
	
	@Override
	public
Set<Owner >findAll() {
	return super.findAll();
}
	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Owner save(Owner o) {
		return super.save(o.getId(),o);
	}
	
	
	public void delete(Owner o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}
