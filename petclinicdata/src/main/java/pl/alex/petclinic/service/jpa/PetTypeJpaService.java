package pl.alex.petclinic.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.PetType;
import pl.alex.petclinic.repositories.PetTypeRepository;
import pl.alex.petclinic.service.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

	private final PetTypeRepository PetTypeRepository;

	public PetTypeJpaService(PetTypeRepository PetTypeRepository) {
		this.PetTypeRepository = PetTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> PetTypes = new HashSet<>();
		PetTypeRepository.findAll().forEach(PetTypes::add);
		return PetTypes;

	}

	@Override
	public PetType findById(Long id) {
		return PetTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return PetTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		PetTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		PetTypeRepository.deleteById(id);
	}

}
