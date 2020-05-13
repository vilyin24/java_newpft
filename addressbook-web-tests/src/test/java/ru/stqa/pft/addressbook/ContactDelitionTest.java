package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    goToContactPage();
    selectContact();
    deleteContact();
    closeAlertForWindowsContact();
    goToContactPage();
  }

}
