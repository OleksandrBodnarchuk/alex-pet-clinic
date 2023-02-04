package pl.alex.petclinic.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.Owner;
import pl.alex.petclinic.repositories.OwnerRepository;
import pl.alex.petclinic.repositories.PetRepository;
import pl.alex.petclinic.repositories.PetTypeRepository;
import pl.alex.petclinic.service.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetTypeRepository petTypeRepository;
	private final PetRepository petRepository;

	public OwnerJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
			PetRepository petRepository) {
		this.ownerRepository = ownerRepository;
		this.petTypeRepository = petTypeRepository;
		this.petRepository = petRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
