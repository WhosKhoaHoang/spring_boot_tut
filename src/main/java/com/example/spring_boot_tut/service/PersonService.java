package com.example.spring_boot_tut.service;

import com.example.spring_boot_tut.dao.PersonDao;
import com.example.spring_boot_tut.model.Person;


// THINK: Generally, a service class contains the business
//        logic that the APIs will use. It's a good way to
//        organize the code so that we don't have to define
//        that business logic in the class for the API.
public class PersonService {

  // Make sure that you're declaring the interface and
  // not the concrete class implementing the interface
  // so that we can use dependency injection (which aids
  // in enhancing the generalizability/flexibility of our code)
  private final PersonDao personDao;

  public PersonService(PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }
}
