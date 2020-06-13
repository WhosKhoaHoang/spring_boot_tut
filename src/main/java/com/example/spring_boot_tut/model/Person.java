package com.example.spring_boot_tut.model;

import java.util.UUID;

public class Person {
  private final UUID id;
  private final String name;

  public Person(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
