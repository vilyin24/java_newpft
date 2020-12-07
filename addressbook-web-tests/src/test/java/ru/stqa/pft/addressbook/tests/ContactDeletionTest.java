package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().goToContactPage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("test1",null,null,"test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnContactPage();
  }

}
