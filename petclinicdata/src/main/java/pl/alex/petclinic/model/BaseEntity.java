package pl.alex.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5987401129673597710L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
