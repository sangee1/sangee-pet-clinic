package com.example.sangeepetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {


	@Column(name = "name")
	private String name;

	public PetType() {
		// TODO Auto-generated constructor stub
	}

	public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }
	
	public PetType(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public PetType(String name) {
		super();
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	
}
