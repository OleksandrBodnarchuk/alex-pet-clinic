package pl.alex.petclinic.service;

import java.util.Set;

import pl.alex.petclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> findAll();

}
