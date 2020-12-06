package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTest  extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().initContact();
    app.getContactHelper().fiiContactForm(new ContactDate("1", null, "3","1"),true);
    app.getContactHelper().sumbitContactCreation();
    app.getContactHelper().returnContactPage();
  }

}
