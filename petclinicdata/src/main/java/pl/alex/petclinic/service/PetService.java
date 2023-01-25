package pl.alex.petclinic.service;

import java.util.Set;

import pl.alex.petclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();

}
