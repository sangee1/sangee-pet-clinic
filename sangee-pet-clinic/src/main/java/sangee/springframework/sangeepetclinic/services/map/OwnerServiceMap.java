package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.services.CrudService;
import sangee.springframework.sangeepetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{
	
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
	}
	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	};

	

}
