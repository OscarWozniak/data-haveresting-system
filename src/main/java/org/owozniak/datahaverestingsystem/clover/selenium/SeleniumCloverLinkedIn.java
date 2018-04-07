package org.owozniak.datahaverestingsystem.clover.selenium;

import org.owozniak.datahaverestingsystem.clover.selenium.browser.Browser;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.AuthData;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;
import org.owozniak.datahaverestingsystem.clover.selenium.pages.ConnectionsPage;
import org.owozniak.datahaverestingsystem.clover.selenium.pages.LoginPage;
import org.owozniak.datahaverestingsystem.clover.selenium.pages.ProfilePage;
import org.owozniak.datahaverestingsystem.clover.selenium.pages.components.ConnectionsBar;
import org.owozniak.datahaverestingsystem.clover.selenium.pages.components.NavigationBar;
import org.owozniak.datahaverestingsystem.models.LinkedInCloverModel;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeleniumCloverLinkedIn {

  public static final int DEFAULT_SCROLLING_WAIT_TIME = 10;
  static final ProfilePage profilePage = new ProfilePage();
  static final LoginPage loginPage = new LoginPage();
  static final NavigationBar navigationBar = new NavigationBar();
  static final ConnectionsBar connectionsBar = new ConnectionsBar();
  static final ConnectionsPage connectionsPage = new ConnectionsPage();

  public static List<Profile> getFriendsProfiles(int limit, AuthData authData) {
    loginPage.navigate();
    loginPage.login(authData);

    navigationBar.navigateToMyNetwork();

    int connectionsCount = connectionsBar.getConnectionsCount();
    connectionsBar.clickSeeAllConnections();

    scrollTillAllProfilesLoaded(connectionsCount, DEFAULT_SCROLLING_WAIT_TIME);
    List<Profile> profiles = mapLinkAsProfiles(limit);

    profiles.stream().forEach(p -> out.println(p.toString()));

    Browser.get().close();

    return profiles;
  }

  private static List<Profile> mapLinkAsProfiles(int limit) {
    return connectionsPage.mapCardToLink().stream()
            .limit(limit)
            .map(link -> {
              Browser.navigate(link);
              return profilePage.asObject();
            }).collect(Collectors.toList());
  }

  private static void scrollTillAllProfilesLoaded(int connectionsCount, int maxWaitingTimeIfNothingHappens) {
    int previousCount = 0;
    long startingSeconds = Instant.now().getEpochSecond();

    do {
      Browser.scroll(250);

      int actualCount = connectionsPage.getPersonCardCount();
      if (sameCounts(previousCount, actualCount)) {
        if (waitingTooLong(maxWaitingTimeIfNothingHappens, startingSeconds)) {
          return;
        }
      } else {
        previousCount = actualCount;
        startingSeconds = Instant.now().getEpochSecond();
      }

    } while (connectionsPage.getPersonCardCount() < connectionsCount);
  }

  private static boolean waitingTooLong(int maxWaitingTimeIfNothingHappens, long startingSeconds) {
    return startingSeconds + maxWaitingTimeIfNothingHappens >= Instant.now().getEpochSecond();
  }

  private static boolean sameCounts(int previousCount, int actualCount) {
    return previousCount == actualCount;
  }

  public static List<Profile> getFriendsProfiles(LinkedInCloverModel model) {
    return getFriendsProfiles(model.getLimit(), model.getAuth());
  }
}
