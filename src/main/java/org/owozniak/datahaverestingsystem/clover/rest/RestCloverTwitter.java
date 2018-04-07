package org.owozniak.datahaverestingsystem.clover.rest;

import org.owozniak.datahaverestingsystem.clover.rest.builder.TwitterOAuth;
import org.owozniak.datahaverestingsystem.clover.rest.builder.TwitterWrapper;
import org.owozniak.datahaverestingsystem.clover.rest.entity.TwitterUser;
import org.owozniak.datahaverestingsystem.models.TwitterCloverModel;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RestCloverTwitter {

  public static List<TwitterUser> getTwitterFollowers(TwitterOAuth oAuth, String friendIdName) throws TwitterException {
    Twitter twitter = TwitterWrapper.create(oAuth);

    long[] iDs = twitter.getFriendsIDs(friendIdName, -1).getIDs();

    return mapToUsers(twitter, iDs);
  }

  private static List<TwitterUser> mapToUsers(Twitter twitter, long[] iDs) {
    return LongStream.of(iDs)
            .mapToObj(id ->createUser(twitter, id))
            .collect(Collectors.toList());
  }

  private static TwitterUser createUser(Twitter twitter, long id) {
    try {
      User user = twitter.users().showUser(id);
      ResponseList<Status> timeLine = twitter.timelines().getUserTimeline(id);

      return TwitterUser.create(user, timeLine);
    } catch (TwitterException e) {
      return TwitterUser.create(id, e.getMessage());
    }
  }

  public static List<TwitterUser> getTwitterFollowers(TwitterCloverModel model) throws TwitterException {
    return getTwitterFollowers(model.getAuth(), model.getFriendIdName());
  }
}
