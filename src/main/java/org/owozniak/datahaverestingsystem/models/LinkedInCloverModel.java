package org.owozniak.datahaverestingsystem.models;

import org.owozniak.datahaverestingsystem.clover.selenium.entities.AuthData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedInCloverModel {
  AuthData auth;
  int limit;
}
