package pl.alex.petclinic.service;

import pl.alex.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
