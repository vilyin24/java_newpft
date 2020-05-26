package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    app.getNavigationHelper().goToContactPage();
    if(!app.getContactHelper().isThereContact()){
    app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnToContactPage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
  }

}
