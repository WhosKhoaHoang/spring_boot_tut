package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// NOTE: DAO stands for Data Access Object
public interface PersonDao {

  int insertPerson(UUID id, Person person);

  default int insertPerson(Person person) {
    // It's of course a bad idea to just randomly generate an ID.
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<Person> selectAllPeople();

  // The reason for using Optional<Person> is that there may
  // or may not be a result for the given ID!
  Optional<Person> selectPersonById(UUID id);

  int deletePersonById(UUID id);

  int updatePersonById(UUID id, Person person);
}
