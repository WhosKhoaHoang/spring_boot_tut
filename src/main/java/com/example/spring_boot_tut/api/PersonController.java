package com.example.spring_boot_tut.api;

import com.example.spring_boot_tut.model.Person;
import com.example.spring_boot_tut.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
