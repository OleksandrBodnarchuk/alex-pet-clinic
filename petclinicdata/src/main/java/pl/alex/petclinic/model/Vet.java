package pl.alex.petclinic.model;

import java.util.Set;

public class Vet extends Person {

	private static final long serialVersionUID = 2216851049397048588L;

	private Set<Speciality> specialities;

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}

}
