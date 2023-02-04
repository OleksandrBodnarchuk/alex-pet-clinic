package pl.alex.petclinic.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.Pet;
import pl.alex.petclinic.repositories.PetRepository;
import pl.alex.petclinic.service.PetService;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

	private final PetRepository PetRepository;

	public PetJpaService(PetRepository PetRepository) {
		this.PetRepository = PetRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> Pets = new HashSet<>();
		PetRepository.findAll().forEach(Pets::add);
		return Pets;

	}

	@Override
	public Pet findById(Long id) {
		return PetRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return PetRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		PetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		PetRepository.deleteById(id);
	}

}
