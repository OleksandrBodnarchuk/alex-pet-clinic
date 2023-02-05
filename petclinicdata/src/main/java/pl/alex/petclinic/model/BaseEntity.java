package pl.alex.petclinic.model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5987401129673597710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
