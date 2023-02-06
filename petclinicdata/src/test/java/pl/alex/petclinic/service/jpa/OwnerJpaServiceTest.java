package pl.alex.petclinic.service.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.alex.petclinic.model.Owner;
import pl.alex.petclinic.repositories.OwnerRepository;
import pl.alex.petclinic.repositories.PetRepository;
import pl.alex.petclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

	public static final String LAST_NAME = "Smith";
	@Mock
	OwnerRepository ownerRepository;

	@Mock
	PetRepository petRepository;

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerJpaService service;

	Owner returnOwner;

	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
	}

	@Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

	@Test
	void findAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(1l).build());
		returnOwnersSet.add(Owner.builder().id(2l).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

		Set<Owner> owners = service.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

	@Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

	@Test
	void save() {
		Owner ownerToSave = Owner.builder().id(1L).build();

		when(ownerRepository.save(any())).thenReturn(returnOwner);

		Owner savedOwner = service.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	void delete() {
		service.delete(returnOwner);

		// default is 1 times
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void deleteById() {
		service.deleteById(1L);

		verify(ownerRepository).deleteById(anyLong());
	}
}