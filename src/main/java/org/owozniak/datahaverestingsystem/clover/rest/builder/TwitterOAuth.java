package org.owozniak.datahaverestingsystem.clover.rest.builder;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TwitterOAuth {
  String accessToken;
  String accessTokenSecret;
  String consumerKey;
  String consumerSecret;
}
