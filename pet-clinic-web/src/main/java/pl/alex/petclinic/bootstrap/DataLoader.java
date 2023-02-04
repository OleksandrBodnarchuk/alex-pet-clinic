package pl.alex.petclinic.bootstrap;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.alex.petclinic.model.Owner;
import pl.alex.petclinic.model.Pet;
import pl.alex.petclinic.model.PetType;
import pl.alex.petclinic.model.Specialty;
import pl.alex.petclinic.model.Vet;
import pl.alex.petclinic.service.OwnerService;
import pl.alex.petclinic.service.PetTypeService;
import pl.alex.petclinic.service.SpecialtyService;
import pl.alex.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtiesService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtiesService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtiesService = specialtiesService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedPetTypeDog = petTypeService.save(dog);
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedPetTypeCat = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("654987321");

		Pet owner1Pet = new Pet();
		owner1Pet.setName("Ralphie");
		owner1Pet.setBirthDate(LocalDate.now());
		owner1Pet.setPetType(savedPetTypeDog);
		owner1.getPets().add(owner1Pet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("654987321");

		Pet owner2Pet = new Pet();
		owner2Pet.setName("Biggie");
		owner2Pet.setBirthDate(LocalDate.now());
		owner2Pet.setPetType(savedPetTypeCat);
		owner2.getPets().add(owner2Pet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Specialty radiology = new Specialty();
		radiology.setName("Radiology");
		radiology = specialtiesService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setName("Surgery");
		surgery = specialtiesService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setName("Dentistry");
		dentistry = specialtiesService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(dentistry);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(surgery);
		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
