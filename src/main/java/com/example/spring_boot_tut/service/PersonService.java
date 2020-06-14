package com.example.spring_boot_tut.service;

import com.example.spring_boot_tut.dao.PersonDao;
import com.example.spring_boot_tut.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


// THINK: Generally, a service class contains the business
//        logic that the APIs will use. It's a good way to
//        organize the code so that we don't have to define
//        that business logic in the class for the API! The
//        PersonDao class in PersonDao.java is like another
//        layer in that encapsulation chain.

// Need to declare this @Service annotation to indicate to Spring
// that this class is to be used as a service.
@Service
public class PersonService {

  private final PersonDao personDao;
  // Make sure that you're declaring the interface here and
  // not the concrete class implementing the interface
  // so that we can use dependency injection (which aids
  // in establishing loose couplings between code constructs
  // and enhancing the generalizability/flexibility of our code)

  @Autowired
  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    // Because we may have many different implementations
    // of a PersonDao interface, we need to have a way to
    // distinguish between them. This combination of using
    // the @Autowired and @Qualifier decorators helps us do this.
    // Also note that the String passed to @Qualifier seems to need
    // to be the name of, say, the DB the DAO is interfacing with.
    // It also needs to match the string passed to the @Repository
    // annotation for the PersonDao interface.
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  // The reason for using Optional<Person> is that there may
  // or may not be a result for the given ID!
  public Optional<Person> selectPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }
}
