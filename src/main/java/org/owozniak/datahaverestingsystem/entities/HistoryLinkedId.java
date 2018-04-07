package org.owozniak.datahaverestingsystem.entities;

import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class HistoryLinkedId {

  @Id
  @GeneratedValue
  long id;

  Date date;
  String userName;
  int count;

//  List<Profile> profiles;

  private HistoryLinkedId(Date date, String userName, int count, List<Profile> profiles) {
    this.date = date;
    this.userName = userName;
    this.count = count;
//    this.profiles = profiles;
  }

  public static HistoryLinkedId create(String userName, List<Profile> profiles){
    return new HistoryLinkedId(new Date(), userName, profiles.size(), profiles);
  }
}
