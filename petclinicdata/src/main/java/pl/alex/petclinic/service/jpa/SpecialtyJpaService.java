package pl.alex.petclinic.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.Specialty;
import pl.alex.petclinic.repositories.SpecialtyRepository;
import pl.alex.petclinic.service.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService {

	private final SpecialtyRepository SpecialtyRepository;

	public SpecialtyJpaService(SpecialtyRepository SpecialtyRepository) {
		this.SpecialtyRepository = SpecialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> Specialtys = new HashSet<>();
		SpecialtyRepository.findAll().forEach(Specialtys::add);
		return Specialtys;

	}

	@Override
	public Specialty findById(Long id) {
		return SpecialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return SpecialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		SpecialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		SpecialtyRepository.deleteById(id);
	}

}
