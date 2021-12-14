package com.example.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sangeepetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
