package org.owozniak.datahaverestingsystem.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.owozniak.datahaverestingsystem.clover.selenium.entities.Profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryLogItem {

  @Id
  @GeneratedValue
  long id;
  Date date;
  String userName;
  int count;

  private HistoryLogItem(Date date, String userName, int count) {
    this.date = date;
    this.userName = userName;
    this.count = count;
  }

  public static HistoryLogItem create(String userName, List<Profile> profiles) {
    return new HistoryLogItem(new Date(), userName, profiles.size());
  }
}
