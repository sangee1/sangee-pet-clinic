package sangee.springframework.sangeepetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.model.Pet;
import sangee.springframework.sangeepetclinic.services.PetService;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap() );
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(1L,owners.size());
	}

	@Test
	void testFindByIdLong() {
		assertEquals(ownerId, ownerServiceMap.findById(ownerId).getId());
	}

	@Test
	void testSaveOwner() {
		Owner owner2 = Owner.builder().id(2L).build();
		assertEquals(owner2, ownerServiceMap.save(owner2));
		
	}

	@Test
	void testSaveNoId() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
		
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerServiceMap.findByLastName(lastName);
		assertNotNull(smith);
		assertEquals(lastName, smith.getLastName());
		
	}
	
	@Test
	void testFindByLastNameNotFound() {
		Owner foo = ownerServiceMap.findByLastName("foo");
		assertNull(foo);
		
		
	}

}
