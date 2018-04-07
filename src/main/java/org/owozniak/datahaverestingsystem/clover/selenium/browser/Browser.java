package org.owozniak.datahaverestingsystem.clover.selenium.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

  public static final int DEFAULT_TEMP_LIMIT = 3;
  private static final String PATH_TO_DRIVER = "./src/main/java/org/owozniak/datahaverestingsystem/clover/selenium/resources/geckodriver";
  private static final int DEFAULT_GLOBAL_LIMIT = 30;
  private static WebDriver driver = null;

  private Browser() {
  }

  public static WebDriver get() {
    return driver == null ? newDriver() : oldDriver();
  }

  private static WebDriver oldDriver() {
    return driver;
  }

  private static WebDriver newDriver() {
    System.setProperty("webdriver.gecko.driver", PATH_TO_DRIVER);

    driver = new FirefoxDriver();
    setWaiters(driver, DEFAULT_GLOBAL_LIMIT);

    return driver;
  }

  private static void setWaiters(int limit) {
    setWaiters(driver, limit);
  }

  private static void setWaiters(WebDriver driver, int limit) {
    driver.manage().timeouts().implicitlyWait(limit, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(limit, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(limit, TimeUnit.SECONDS);
  }


  public static void scroll(int movement) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0," + movement + ")", "");
  }

  public static void navigate(String link) {
    driver.get(link);
  }

  public static void run(Runnable runnable, int temporaryLimit) {
    setWaiters(temporaryLimit);
    runnable.run();
    setWaiters(DEFAULT_GLOBAL_LIMIT);
  }

  public static void run(Runnable runnable) {
    run(runnable, DEFAULT_TEMP_LIMIT);
  }

  public static void find(WebElement element, By by){
//    ToDO https://stackoverflow.com/questions/10660291/highlight-elements-in-webdriver-during-runtime
  }

}
