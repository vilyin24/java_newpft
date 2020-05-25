package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    app.getNavigationHelper().goToContactPage();
    int before = app.getContactHelper().getContactCount();
    if(!app.getContactHelper().isThereContact()){
    app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
    }
    app.getContactHelper().selectContact(before -1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);
  }

}
