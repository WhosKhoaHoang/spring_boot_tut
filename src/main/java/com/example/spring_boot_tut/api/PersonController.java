package com.example.spring_boot_tut.api;

import com.example.spring_boot_tut.model.Person;
import com.example.spring_boot_tut.service.PersonService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Implement PATCH and DELETE

// It is customary to call the class for
// the API a "controller".

// @RequestMapping defines the URL for this API
// @RestController establishes this class as a REST controller
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody Person person) {
    // @RequestBody says that we want to take the body of the
    // incoming HTTP request and put that inside of this person
    // object
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

  @GetMapping(path = "{id}")
  public Person getPersonById(@PathVariable("id") UUID id) {
    // More realistically, you'd want to return a 404 error
    // if no user exists instead of a successful response with
    // an empty body!!!
    return personService.selectPersonById(id)
                        .orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public int deletePersonById(@PathVariable("id") UUID id) {
    return personService.deletePersonById(id);
  }

}
