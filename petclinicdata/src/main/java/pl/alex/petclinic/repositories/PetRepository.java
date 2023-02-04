package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
