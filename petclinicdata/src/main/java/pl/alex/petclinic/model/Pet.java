package pl.alex.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

	private static final long serialVersionUID = 4628524401418340296L;
	private String name;
	private LocalDate birthDate;
	private PetType petType;
	private Owner owner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}