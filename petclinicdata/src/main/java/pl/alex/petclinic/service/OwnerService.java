package pl.alex.petclinic.service;

import java.util.Set;

import pl.alex.petclinic.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();

}
