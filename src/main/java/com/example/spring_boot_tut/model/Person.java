package com.example.spring_boot_tut.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Person {
  private final UUID id;
  private final String name;

  // Add the @JsonProperty annotation so that Spring
  // can interpret JSON requests as Java objects (i.e.,
  // POJOs [Plain Old Java Objects?]?)
  public Person(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name) {
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
