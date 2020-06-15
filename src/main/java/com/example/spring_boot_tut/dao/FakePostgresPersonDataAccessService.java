package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;


@Repository("fakePostgres")
public class FakePostgresPersonDataAccessService implements PersonDao {

  @Override
  public int insertPerson(UUID id, Person person) {
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    //List<Person> personList = new ArrayList<Person>();
    //personList.add(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));

    //REMINDER: Shorthand for initializing an ArrayList with elements
    List<Person> personList = new ArrayList<Person>() {
      { add(new Person(UUID.randomUUID(), "FROM POSTGRES DB")); }
    };

    // Unfortunately, Java 8 doesn't support List.of()
    //return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB");
    return personList;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return Optional.empty();
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
