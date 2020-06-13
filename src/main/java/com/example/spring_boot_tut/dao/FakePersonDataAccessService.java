package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

// PROTIP: Note how similar the syntax for Java annotations
//         is identical to the syntax for function decorators
//         in Python. Be that as it may, the two of them accom-
//         plish different things! See this SO discussion:
//         https://stackoverflow.com/questions/15347136/

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
}
