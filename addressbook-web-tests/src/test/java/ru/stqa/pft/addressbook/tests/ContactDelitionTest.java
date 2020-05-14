package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnToContactPage();
  }

}
