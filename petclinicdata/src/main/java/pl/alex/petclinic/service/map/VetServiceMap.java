package pl.alex.petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.alex.petclinic.model.Vet;
import pl.alex.petclinic.service.SpecialtyService;
import pl.alex.petclinic.service.VetService;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if (object.getSpecialities() != null) {
				object.getSpecialities().forEach(specialtyService::save);
			} else {
				throw new RuntimeException("Vet speciality is required!");
			}
			return super.save(object);
		}
		return null;
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
