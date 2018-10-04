package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Speciality;
import sangee.springframework.sangeepetclinic.model.Vet;
import sangee.springframework.sangeepetclinic.services.SpecialtyService;
import sangee.springframework.sangeepetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService{
	
	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService) {
	super();
	this.specialtyService = specialtyService;
}
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
		if(o.getSpecialities().size() > 0){
			o.getSpecialities().forEach(specialty -> {
				if(specialty.getId() == null){
					Speciality savedSpeciality = specialtyService.save(specialty);
					specialty.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(o);
	}
	
	
	public void delete(Vet o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	};

	

}

