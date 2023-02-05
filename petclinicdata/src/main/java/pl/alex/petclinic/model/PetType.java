package pl.alex.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetType extends BaseEntity {

	private static final long serialVersionUID = -7415170983425399449L;

	@Column(name = "name")
	private String name;

}
