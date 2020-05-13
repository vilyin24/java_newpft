package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    app.goToContactPage();
    app.selectContact();
    app.deleteContact();
    app.closeAlertForWindowsContact();
    app.goToContactPage();
  }

}
