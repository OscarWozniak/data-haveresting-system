package org.owozniak.datahaverestingsystem.clover.selenium.pages;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConnectionsPage extends Page {

  @Getter
  @FindBy(css = ".mn-connections__list .mn-person-card")
  List<WebElement> personCard;

  public ConnectionsPage() {
    super("https://www.linkedin.com/mynetwork/invite-connect/connections/");
  }

  public int getPersonCardCount() {
    return personCard.size();
  }

  public List<String> mapCardToLink(){
    return personCard.stream()
            .map(c -> c
                    .findElement(By.className("mn-person-info__link"))
                    .getAttribute("href"))
            .collect(Collectors.toList());
  }

}
