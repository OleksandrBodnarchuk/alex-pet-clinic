package pl.alex.petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.Speciality;
import pl.alex.petclinic.service.SpecialtiesService;

@Service
public class VetSpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtiesService {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
