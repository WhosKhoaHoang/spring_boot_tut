package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.UUID;

// NOTE: DAO stands for Data Access Object
public interface PersonDao {

  int insertPerson(UUID id, Person person);

  default int addPerson(Person person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }
}
