package org.owozniak.datahaverestingsystem.test;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Test {
  @Id
  @GeneratedValue
  long id;

  String name;

  public Test(String name) {
    this.name = name;
  }
}
