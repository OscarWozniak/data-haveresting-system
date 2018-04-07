package org.owozniak.datahaverestingsystem.clover.selenium.pages;

import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.ProfileEducation;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.ProfileExperience;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

//https://stackoverflow.com/questions/47056180/make-stream-list-more-generic-for-functions?noredirect=1#comment81062074_47056180
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfilePage extends Page{

  @FindBy(css = "#experience-section .pv-profile-section__card-item")
  List<WebElement> experiencelist;

  @FindBy(css = "#education-section .pv-education-entity")
  List<WebElement> educationList;

  @FindBy(className = "pv-top-card-section__name")
  WebElement fullName;

  @FindBy(className = "pv-top-card-section__location")
  WebElement location;

  public ProfilePage() {
    super("");
  }

  public String getFullName(){
    return fullName.getText();
  }

  public String getLocation(){
    return location.getText();
  }

  public List<ProfileExperience> getExperience() {
    return experiencelist.stream()
            .map(ProfileExperience::new)
            .collect(Collectors.toList());
  }

  public List<ProfileEducation> getEducation() {
    return educationList.stream()
            .map(ProfileEducation::new)
            .collect(Collectors.toList());
  }

  public Profile asObject(){
    return Profile.of(this);
  }

}
