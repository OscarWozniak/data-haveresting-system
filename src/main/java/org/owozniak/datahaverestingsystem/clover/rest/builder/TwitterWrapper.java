package org.owozniak.datahaverestingsystem.clover.rest.builder;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterWrapper {

  private TwitterWrapper() {
  }

  public static Twitter create(TwitterOAuth oAuth) {
    Configuration conf = new ConfigurationBuilder()
            .setDebugEnabled(false)
            .setOAuthConsumerKey(oAuth.getConsumerKey())
            .setOAuthConsumerSecret(oAuth.getConsumerSecret())
            .setOAuthAccessToken(oAuth.getAccessToken())
            .setOAuthAccessTokenSecret(oAuth.getAccessTokenSecret()).build();

    return new TwitterFactory(conf).getInstance();
  }
}
