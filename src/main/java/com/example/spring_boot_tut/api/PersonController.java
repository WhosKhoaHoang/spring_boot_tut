package com.example.spring_boot_tut.api;

import com.example.spring_boot_tut.model.Person;
import com.example.spring_boot_tut.service.PersonService;

// It is customary to call the class for
// the API a "controller"
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void addPerson(Person person) {
    personService.addPerson(person);
  }
}
