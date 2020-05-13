package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    goToContactPage();
    initContact();
    fiiContactForm(new ContactDate("1", "2", "3"));
    sumbitContactCreation();
    goToContactPage();
  }

}
