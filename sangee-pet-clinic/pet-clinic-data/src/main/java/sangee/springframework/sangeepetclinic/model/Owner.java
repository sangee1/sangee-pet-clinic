package sangee.springframework.sangeepetclinic.model;

import java.util.Set;

public class Owner extends Person {
	private String adddress;
	private String city;
	private String telephone;
	
	private Set<Pet> pets;

	public String getAdddress() {
		return adddress;
	}

	public void setAdddress(String adddress) {
		this.adddress = adddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	
	}
	
	
	
	

}
