package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
