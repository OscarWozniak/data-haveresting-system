package org.owozniak.datahaverestingsystem.controllers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.owozniak.datahaverestingsystem.clover.rest.RestCloverTwitter;
import org.owozniak.datahaverestingsystem.clover.rest.entity.TwitterUser;
import org.owozniak.datahaverestingsystem.clover.selenium.SeleniumCloverLinkedIn;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.AuthData;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;
import org.owozniak.datahaverestingsystem.entities.HistoryLinkedId;
import org.owozniak.datahaverestingsystem.entities.HistoryTwitter;
import org.owozniak.datahaverestingsystem.models.LinkedInCloverModel;
import org.owozniak.datahaverestingsystem.models.TwitterCloverModel;
import org.owozniak.datahaverestingsystem.repositories.HistoryLinkedInRepository;
import org.owozniak.datahaverestingsystem.repositories.HistoryTwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloverController {

  @Autowired
  HistoryTwitterRepository twitterRepository;
  @Autowired
  HistoryLinkedInRepository linkedInRepository;

  @PostMapping("/clover/twitter")
  public List<TwitterUser> getTwitterProfiles(@RequestBody TwitterCloverModel model) throws TwitterException {
    List<TwitterUser> twitterFollowers = RestCloverTwitter.getTwitterFollowers(model);
    HistoryTwitter history = HistoryTwitter.create(model.getFriendIdName(), twitterFollowers);

    twitterRepository.save(history);

    return twitterFollowers;
  }

  @PostMapping("/clover/linked-in")
  public List<Profile> getLinkedInProfiles(@RequestBody LinkedInCloverModel model) {
    List<Profile> profiles = SeleniumCloverLinkedIn.getFriendsProfiles(model);
    HistoryLinkedId history = HistoryLinkedId.create(model.getAuth().getLogin(), profiles);

    linkedInRepository.save(history);

    return profiles;
  }
}
