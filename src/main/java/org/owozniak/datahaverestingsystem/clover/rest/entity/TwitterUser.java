package org.owozniak.datahaverestingsystem.clover.rest.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TwitterUser {

  @Id
  @GeneratedValue
  long id;
  String name;
  String email;
  String location;
  String exception;

  @OneToMany
  List<TwitterTweet> tweets;

  public static TwitterUser create(User user, ResponseList<Status> timeLine) {
    return new TwitterUser() {{
      setEmail(user.getEmail());
      setId(user.getId());
      setLocation(user.getLocation());
      setName(user.getName());
      setTweets(TwitterTweet.create(timeLine));
    }};
  }

  public static TwitterUser create(long id, String exception) {
    return new TwitterUser() {{
      setId(id);
      setException(exception);
    }};
  }
}
