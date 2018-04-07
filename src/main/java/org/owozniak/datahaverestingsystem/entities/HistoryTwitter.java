package org.owozniak.datahaverestingsystem.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.owozniak.datahaverestingsystem.clover.rest.entity.TwitterUser;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class HistoryTwitter {

  @Id
  @GeneratedValue
  long id;

  Date date;
  String userName;
  int count;

  @OneToMany
  List<TwitterUser> profiles;

  private HistoryTwitter(Date date, String userName, List<TwitterUser> profiles) {
    this.date = date;
    this.userName = userName;
    this.count = profiles.size();
    this.profiles = profiles;
  }

  public static HistoryTwitter create(String userName, List<TwitterUser> profiles){
    return new HistoryTwitter(new Date(), userName,  profiles);
  }
}
