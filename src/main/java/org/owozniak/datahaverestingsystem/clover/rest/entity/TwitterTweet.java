package org.owozniak.datahaverestingsystem.clover.rest.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import twitter4j.ResponseList;
import twitter4j.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Entity
public class TwitterTweet {
  @Id
  @GeneratedValue
  long id;
  String text;

  public static List<TwitterTweet> create(ResponseList<Status> timeLine) {
    return timeLine.stream()
            .map(TwitterTweet::create)
            .collect(Collectors.toList());
  }

  private static TwitterTweet create(Status tweet) {
    return new TwitterTweet() {{
      setId(tweet.getId());
      setText(tweet.getText());
    }};
  }
}
