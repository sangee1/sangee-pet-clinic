package sangee.springframework.sangeepetclinic.bootstrap;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.model.PetType;
import sangee.springframework.sangeepetclinic.model.Speciality;
import sangee.springframework.sangeepetclinic.model.Vet;
import sangee.springframework.sangeepetclinic.services.OwnerService;
import sangee.springframework.sangeepetclinic.services.PetTypeService;
import sangee.springframework.sangeepetclinic.services.SpecialtyService;
import sangee.springframework.sangeepetclinic.services.VetService;
import sangee.springframework.sangeepetclinic.services.map.OwnerServiceMap;
import sangee.springframework.sangeepetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService,SpecialtyService specialtyService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService =specialtyService;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		if(count ==0){
			loadData();
		}
		
	}


	private void loadData() {
		PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");
        
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setName("Rosco");
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        
        owner1.getPets().add(mikesPet);
       ownerService.save(owner1);
       
       Owner owner2 = new Owner();
       owner2.setFirstName("Fiona");
       owner2.setLastName("Glenanne");
       owner2.setAddress("123 Brickerel");
       owner2.setCity("Miami");
       owner2.setTelephone("1231231234");
       
       Pet fionasCat = new Pet();
       fionasCat.setName("Just Cat");
       fionasCat.setPetType(savedCatPetType);
       fionasCat.setBirthDate(LocalDate.now());
       fionasCat.setOwner(owner2);
       
       owner2.getPets().add(fionasCat);
       ownerService.save(owner2);
       System.out.println("Loaded Owners....");
       
       Speciality radiology = new Speciality();
       radiology.setDescription("Radiology");
       Speciality savedRadiology = specialtyService.save(radiology);

       Speciality surgery = new Speciality();
       surgery.setDescription("Surgery");
       Speciality savedSurgery = specialtyService.save(surgery);

       Speciality dentistry = new Speciality();
       dentistry.setDescription("dentistry");
       Speciality savedDentistry = specialtyService.save(dentistry);
       
       Vet vet1 = new Vet();
       vet1.setFirstName("Sam");
       vet1.setLastName("Axe");
       vet1.getSpecialities().add(savedRadiology);
      
       vetService.save(vet1);

       Vet vet2 = new Vet();
       
       vet2.setFirstName("Jessie");
       vet2.setLastName("Porter");
       vet2.getSpecialities().add(savedSurgery);
       
       vetService.save(vet2);
       System.out.println("Loaded Vets....");
	}

}
