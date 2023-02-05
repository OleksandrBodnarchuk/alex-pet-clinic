package pl.alex.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

	private static final long serialVersionUID = 6805274449172316979L;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
