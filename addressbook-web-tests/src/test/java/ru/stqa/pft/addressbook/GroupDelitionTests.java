package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupDelitionTests extends TestBase {



  @Test
  public void testGroupDelition() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteGroup();
    gotoGroupPage();
  }

}
