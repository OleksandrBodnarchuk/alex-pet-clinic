package pl.alex.petclinic.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.alex.petclinic.model.Owner;

class OwnerServiceMapTest {

	private static final String OWNER_NAME = "Test";
	private static final long OWNER_ID = 1L;
	private OwnerServiceMap underTest;

	@BeforeEach
	public void setUp() {
		underTest = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		underTest.save(Owner.builder().id(OWNER_ID).lastName(OWNER_NAME).build());

	}

	@Test
	void testFindAll() {
		Set<Owner> all = underTest.findAll();
		assertEquals(1, all.size());
	}

	@Test
	void testFindByIdLong() {
		Owner findById = underTest.findById(OWNER_ID);
		assertTrue(findById != null);
	}

	@Test
	void testSaveOwnerWithId() {
		Long id = 2L;
		Owner owner = underTest.save(Owner.builder().id(id).build());
		assertNotNull(owner);
		assertEquals(id, owner.getId());
	}
	
	@Test
	void testSaveOwnerNoId() {
		Long id = 2L;
		Owner owner = underTest.save(Owner.builder().build());
		assertEquals(id, owner.getId());
		assertNotNull(owner);
	}

	@Test
	void testDeleteOwner() {
		Owner owner = underTest.findById(OWNER_ID);
		underTest.delete(owner);
		assertEquals(0, underTest.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		underTest.deleteById(OWNER_ID);
		assertEquals(0, underTest.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner findByLastName = underTest.findByLastName(OWNER_NAME);
		assertEquals(OWNER_ID, findByLastName.getId());
	}

}
