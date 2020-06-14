package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

// PROTIP: Note how similar the syntax for Java annotations
//         is identical to the syntax for function decorators
//         in Python. Be that as it may, the two of them accom-
//         plish different things! See this SO discussion:
//         https://stackoverflow.com/questions/15347136/

// THINK: This class, along with PersonService in PersonService.java,
//        is like a layer in the encapsulation chain for the business
//        logic (or the code that processes all the data) for an API
//        call (whose endpoints are defined in PersonController.java).

// Declaring this @Component annotation here his is how we
// tell Spring that we want this class to be instantiated as
// a bean so that we can inject it into other classes. Note
// that using the @Component annotation would accomplish the
// same thing, but saying @Repository makes it more semantically
// clear that this class is to be viewed as a Repository.
// - This Repository annotation will allow us to use any database
//   for the DAO.
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

  private static List<Person> DB  = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  // The reason for using Optional<Person> is that there may
  // or may not be a result for the given ID!
  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream()
             .filter(person -> person.getId().equals(id))
             .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    return 0;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return 0;
  }
}
