package org.owozniak.datahaverestingsystem.models;

import org.owozniak.datahaverestingsystem.clover.rest.builder.TwitterOAuth;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TwitterCloverModel {
  TwitterOAuth auth;
  String friendIdName;
  int limit;
}
