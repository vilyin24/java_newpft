package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnContactPage();
  }

}
