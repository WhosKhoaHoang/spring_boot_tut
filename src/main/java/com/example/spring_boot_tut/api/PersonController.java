package com.example.spring_boot_tut.api;

import com.example.spring_boot_tut.model.Person;
import com.example.spring_boot_tut.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

// It is customary to call the class for
// the API a "controller".
// TODO: Use the annotaiton that establishes this class
//       as a REST controller
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void addPerson(Person person) {
    personService.addPerson(person);
  }
}
