package org.owozniak.datahaverestingsystem.clover.selenium.entities;

import org.owozniak.datahaverestingsystem.clover.selenium.pages.ProfilePage;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Profile {
  @Id
  @GeneratedValue
  long id;

  String firstName;
  String surName;
  String location;

  @OneToMany
  List<ProfileExperience> experience;
  @OneToMany
  List<ProfileEducation> education;


  public Profile(String firstName, String surName, String location, List<ProfileExperience> experience, List<ProfileEducation> education) {
    this.firstName = firstName;
    this.surName = surName;
    this.location = location;
    this.experience = experience;
    this.education = education;
  }

  public static Profile of(ProfilePage page) {
    String[] fullName = page.getFullName().split(" ");

    String firstName = fullName[0];
    String surName = fullName[1];
    String location = page.getLocation();
    List<ProfileExperience> experience = page.getExperience();
    List<ProfileEducation> education = page.getEducation();

    return new Profile(firstName, surName, location, experience, education);
  }



}
