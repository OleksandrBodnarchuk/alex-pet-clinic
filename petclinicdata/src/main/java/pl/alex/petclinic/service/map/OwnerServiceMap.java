package pl.alex.petclinic.service.map;

import java.util.Set;

import pl.alex.petclinic.model.Owner;
import pl.alex.petclinic.service.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
	
	
}
