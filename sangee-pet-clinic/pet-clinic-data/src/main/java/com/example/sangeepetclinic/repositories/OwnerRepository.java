package com.example.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sangeepetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);

}
