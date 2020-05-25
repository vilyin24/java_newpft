package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactDate("1","2","3","1"),true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
  }

}
