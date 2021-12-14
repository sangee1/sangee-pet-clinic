package com.example.sangeepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sangeepetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
