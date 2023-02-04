package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
