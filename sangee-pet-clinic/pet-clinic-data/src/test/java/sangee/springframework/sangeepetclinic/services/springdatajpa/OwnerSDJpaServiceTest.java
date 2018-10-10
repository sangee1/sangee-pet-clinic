package sangee.springframework.sangeepetclinic.services.springdatajpa;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sangee.springframework.sangeepetclinic.model.Owner;
import sangee.springframework.sangeepetclinic.repositories.OwnerRepository;
import sangee.springframework.sangeepetclinic.repositories.PetRepository;
import sangee.springframework.sangeepetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	private static final String LASTNAME = "Smith";
	Owner returnOwner;

	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	 PetRepository petRepository;
	
	@Mock
	 PetTypeRepository petTypeRepository;
	 
	@InjectMocks
	 OwnerSDJpaService service;
	 
	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1L).lastName(LASTNAME).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = new HashSet<>();
		ownerSet.add(Owner.builder().id(1L).build());
		ownerSet.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(ownerSet);
		Set<Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(ownerSet, owners);
		assertEquals(2L,owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = service.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownertoSave = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner = service.save(ownertoSave);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
		
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}
	

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(ownerRepository,times(1)).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner smith = service.findByLastName(LASTNAME);
		assertEquals(LASTNAME, smith.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

}
