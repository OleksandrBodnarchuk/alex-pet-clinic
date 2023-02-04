package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
