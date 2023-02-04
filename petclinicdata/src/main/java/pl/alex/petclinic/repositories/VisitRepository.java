package pl.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.alex.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
