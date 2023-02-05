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
@Table(name = "specialities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Specialty extends BaseEntity {

	private static final long serialVersionUID = 2218150992507245256L;
	
	@Column(name = "name")
	private String name;

}
