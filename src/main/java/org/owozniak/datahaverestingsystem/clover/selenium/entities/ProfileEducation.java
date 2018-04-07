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
public class ProfileEducation {
  @Id
  @GeneratedValue
  long id;

  String school;
  String dataRange;
  String secondaryTitle;

  public ProfileEducation(WebElement element) {
    Runnable dataHaverest = () -> {
      this.school = text(() -> element.findElement(By.className("pv-entity__school-name")));
      this.secondaryTitle = text(() -> element.findElement(By.cssSelector(".pv-entity__secondary-title span:nth-child(2)")));
      this.dataRange = text(() -> element.findElement(By.cssSelector(".pv-entity__dates span:nth-child(2)")));
    };

    Browser.run(dataHaverest);
  }
}
