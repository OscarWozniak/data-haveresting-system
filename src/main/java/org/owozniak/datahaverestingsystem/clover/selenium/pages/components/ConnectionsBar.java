package org.owozniak.datahaverestingsystem.clover.selenium.pages.components;

import org.owozniak.datahaverestingsystem.clover.selenium.pages.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConnectionsBar extends Page {
  public ConnectionsBar() {
    super("");
  }

  @FindBy(linkText = "See all")
  WebElement seeAllLint;

  @FindBy(className = "mn-connections-summary__count")
  WebElement connectionsCount;

  public void clickSeeAllConnections(){
    seeAllLint.click();
  }

  public int getConnectionsCount(){
    String text = connectionsCount.getText();

    return Integer.parseInt(text);
  }
}
