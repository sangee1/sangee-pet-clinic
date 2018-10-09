package sangee.springframework.sangeepetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.services.CrudService;
import sangee.springframework.sangeepetclinic.services.OwnerService;
import sangee.springframework.sangeepetclinic.services.PetService;
import sangee.springframework.sangeepetclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
		
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}
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
		Owner savedOwner =null;
		
		if(o !=null){
			//check if petType is null before saving it
			if(o.getPets() != null){
				o.getPets().forEach(pet -> {
					if(pet.getPetType() != null){
						if(pet.getPetType().getId() ==null){
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}
					else{
						throw new RuntimeException("PetType is required");
					}
					if(pet.getId() ==null){
						Pet savedPet =petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
				
			}
		return super.save(o);
		}
		else{
			return null;
		}
	}
	
	
	public void delete(Owner o){
		super.delete(o);
	};
	
	public void deleteById(Long id){
		super.deleteById(id);
	}
	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream().filter(owner -> owner.getLastName().
				equalsIgnoreCase(lastName)).findFirst().orElse(null);
	};

	

}
