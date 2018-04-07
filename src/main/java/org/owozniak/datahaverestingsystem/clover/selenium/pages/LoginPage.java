package org.owozniak.datahaverestingsystem.clover.selenium.pages;

import org.owozniak.datahaverestingsystem.clover.selenium.entities.AuthData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

  @FindBy(id = "login-email")
  private WebElement login;

  @FindBy(id = "login-password")
  private WebElement password;

  @FindBy(id = "login-submit")
  private WebElement submit;

  public LoginPage() {
    super("https://www.linkedin.com/");
  }

  public void login(AuthData authData) {
    login(
            authData.getLogin(),
            authData.getPassword()
    );
  }

  public void login(String login, String password) {
    this.login.sendKeys(login);
    this.password.sendKeys(password);
    this.submit.click();
  }
}
