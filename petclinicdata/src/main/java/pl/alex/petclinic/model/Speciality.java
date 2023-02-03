package pl.alex.petclinic.model;

public class Speciality extends BaseEntity {

	private static final long serialVersionUID = 2218150992507245256L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
