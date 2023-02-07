package pl.alex.petclinic.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import pl.alex.petclinic.model.Owner;
import pl.alex.petclinic.service.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService ownerService;
	@Mock
	private Model model;
	@InjectMocks
	private OwnerController underTest;
	
	private MockMvc mvc;
	private Set<Owner> owners;
	
	@BeforeEach
	public void setUp() {
		owners = new HashSet<>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());
		mvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		
		mvc.perform(get("/owners"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("owners/index"))
			.andExpect(MockMvcResultMatchers.model()
					.attribute("owners", Matchers.hasSize(2)));
	}
	
	@Test
	void testFindOwner() throws Exception {
		mvc.perform(get("/owners/find"))
			.andDo(print())
			.andExpect(view().name("notImplemented"));
		
		Mockito.verifyNoInteractions(ownerService);
	}

}
