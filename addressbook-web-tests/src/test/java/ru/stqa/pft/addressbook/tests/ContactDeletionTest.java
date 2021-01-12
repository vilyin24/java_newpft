package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().goToContactPage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("test1",null,null,"test1"));
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()- 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnContactPage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }


}
