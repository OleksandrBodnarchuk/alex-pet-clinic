package pl.alex.petclinic.model;

public class PetType extends BaseEntity {
	
	private static final long serialVersionUID = -7415170983425399449L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
