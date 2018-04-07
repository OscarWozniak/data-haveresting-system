package org.owozniak.datahaverestingsystem.clover.selenium.pages.components;

import org.owozniak.datahaverestingsystem.clover.selenium.pages.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class NavigationBar extends Page {

  @FindBy(className = "")
  WebElement home;

  @FindBy(css = "a[data-alias='relationships']")
  WebElement myNetwork;

  @FindBy(className = "")
  WebElement jobs;

  @FindBy(className = "")
  WebElement messaging;

  @FindBy(className = "")
  WebElement notifications;

  @FindBy(className = "")
  WebElement me;

  public NavigationBar() {
    super("");
  }

  public void navigateToMyNetwork() {
    myNetwork.click();
  }
}
