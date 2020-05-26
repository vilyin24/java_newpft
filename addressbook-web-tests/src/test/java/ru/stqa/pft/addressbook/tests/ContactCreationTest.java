package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactDate("1","2","3","1"),true);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);
  }

}
