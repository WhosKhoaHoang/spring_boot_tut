package com.example.spring_boot_tut;

import static org.mockito.Mockito.when;

import com.example.spring_boot_tut.api.PersonController;
import com.example.spring_boot_tut.model.Person;
import com.example.spring_boot_tut.service.PersonService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


// NOTE: A Spring Boot application is split into several layers.
//       E.g., Controller->Service->Repository. The tests here
//       cover the Controller layer.

// Don't include @SpringBootTest or a connection attempt to the
// postgres DB will try to be made, which won't work. Refer to here:
//   https://stackoverflow.com/questions/56920276/
//@SpringBootTest(properties = "spring.profiles.active=test")
@RunWith(SpringRunner.class)
@WebMvcTest(value=PersonController.class)
class PersonControllerTests {

	// === Some notes about the test class annotations ===
	// . Is the @RunWith annotation necessary for having other
	//   annotations declared in this class to work? No, things
	//   actually work without it...
	// . @WebMvcTest was the same annotation you
	//   used to get your Kotlin tests to work...
	// . The secure parameter for @WebMvcTest is deprecated
	//   and isn't even recognized anymore.

	// @Autowire is required for tests to work
	@Autowired
	private MockMvc mockMvc;
	// @MockBean is required to properly establish dependencies
	@MockBean
	private PersonService personService;

	/*
	// NOTE: With this setup() defined, I kept on getting NullPointerException
	// when this.mockMvc.perform() was called in testGetAllPeople...Using the
	// @WebMvcTest(value=PersonController.class) annotation (declared at the
	// beginning of this test class definition).
	@Before
	public void setup() {
		PersonController personController = new PersonController(personService);
  	this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
	}
	 */

/*
	@Before
	public void init() {
		// Isn't init just the same as setup()? Or is this executed only
		// once before any tests are run whereas setup is executed every time
		// before each test? Anyway, don't seem to need to define this...
		MockitoAnnotations.initMocks(this);
	}
*/

	@Test
	public void testGetAllPeople() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/person"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[]"));
	}


	@Test
	void testGetPersonById() throws Exception {
		UUID uuid = UUID.randomUUID();
		String name = "James Bond";
		Person person = new Person(uuid, name);
		// TODO: Consider implementing the String implementation for a Person so that
		//       you cause use it for the MockMvcResultMatchers.content().string()) check?
		//       Or you can construct a map with name and person and convert that map to JSON
		//			 and compare that JSON to the response's content? You could use Google's GSON
		//			 library for JSON conversion...
		// Note that selectPersonById() returns can return null...
		when(this.personService.selectPersonById(uuid)).thenReturn(java.util.Optional.of(person));
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/person/"+uuid))
							  .andExpect(MockMvcResultMatchers.status().isOk());
	}
}
