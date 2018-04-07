package org.owozniak.datahaverestingsystem.clover.selenium.entities;

import org.owozniak.datahaverestingsystem.clover.selenium.browser.Browser;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.persistence.*;

import static org.owozniak.datahaverestingsystem.clover.selenium.browser.Browser.DEFAULT_TEMP_LIMIT;
import static org.owozniak.datahaverestingsystem.utils.OptionalUtils.text;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProfileExperience {
  @Id
  @GeneratedValue
  long id;

  String title;
  String secondaryTitle;
  String howLong;
  String where;
  String description;

  public ProfileExperience(WebElement element) {
    Runnable dataHaverest = () -> {
      this.title = text(() -> element.findElement(By.tagName("h3")));
      this.secondaryTitle = text(() -> element.findElement(By.className("pv-entity__secondary-title")));
      this.howLong = text(() -> element.findElement(By.cssSelector(".pv-entity__date-range span:nth-child(2)")));
      this.where = text(() -> element.findElement(By.cssSelector(".pv-entity__location span:nth-child(2)")));
      this.description = text(() -> element.findElement(By.className("pv-entity__description")));
    };

    Browser.run(dataHaverest);
  }
}
