package org.owozniak.datahaverestingsystem.clover.selenium.pages;

import org.owozniak.datahaverestingsystem.clover.selenium.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
  private String url;
  private WebDriver driver;

  protected Page(String url) {
    this.url = url;
    driver = Browser.get();
    PageFactory.initElements(driver, this);
  }

  public void navigate() {
    driver.get(url);
  }

  public void scroll(int movement){
    Browser.scroll(movement);
  }
}
