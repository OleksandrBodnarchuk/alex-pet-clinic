package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

}
