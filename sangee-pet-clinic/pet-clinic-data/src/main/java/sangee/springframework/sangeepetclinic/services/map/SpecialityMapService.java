package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Speciality;
import sangee.springframework.sangeepetclinic.services.SpecialtyService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService{

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality o) {
		// TODO Auto-generated method stub
		return super.save(o);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality o) {
		// TODO Auto-generated method stub
		super.delete(o);
	}
	

}
