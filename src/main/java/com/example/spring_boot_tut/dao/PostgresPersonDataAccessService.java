package com.example.spring_boot_tut.dao;

import com.example.spring_boot_tut.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("postgres")
public class PostgresPersonDataAccessService implements PersonDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PostgresPersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public int insertPerson(UUID id, Person person) {
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    // Consider how it's probably not the best practice
    // to define SQL statements as Strings...
    final String sql = "SELECT id, name FROM person";
    return jdbcTemplate.query(sql, (resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      return new Person(id, name);
    });
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    final String sql = "SELECT id, name FROM person WHERE id = ?";
    Person person = jdbcTemplate.queryForObject(
        sql,
        new Object[]{id},  // Note that this value gets mapped to ? in the sql query string
        (resultSet, i) -> {
          UUID personId = UUID.fromString(resultSet.getString("id"));
          String name = resultSet.getString("name");
          return new Person(personId, name);
        });

    // Say ofNullable() because person could potentially be null
    return Optional.ofNullable(person);
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
