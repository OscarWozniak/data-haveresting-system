package org.owozniak.datahaverestingsystem.controllers;

import org.owozniak.datahaverestingsystem.clover.rest.RestCloverTwitter;
import org.owozniak.datahaverestingsystem.clover.rest.entity.TwitterUser;
import org.owozniak.datahaverestingsystem.clover.selenium.SeleniumCloverLinkedIn;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.AuthData;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;
import org.owozniak.datahaverestingsystem.entities.HistoryLinkedId;
import org.owozniak.datahaverestingsystem.models.LinkedInCloverModel;
import org.owozniak.datahaverestingsystem.models.TwitterCloverModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController
public class CloverController {

  @PostMapping("/clover/twitter")
  public List<TwitterUser> getTwitterProfiles(@RequestBody TwitterCloverModel model) throws TwitterException {
    return RestCloverTwitter.getTwitterFollowers(model);
  }

  @PostMapping("/clover/linked-in")
  public List<Profile> getLinkedInProfiles(@RequestBody LinkedInCloverModel model) {
    List<Profile> profiles = SeleniumCloverLinkedIn.getFriendsProfiles(model);
    HistoryLinkedId history = HistoryLinkedId.create(model.getAuth().getLogin(), profiles);

    return profiles;
  }
}
