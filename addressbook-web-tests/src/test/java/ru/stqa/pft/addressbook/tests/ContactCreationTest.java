package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTest  extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goToContactPage();
    app.initContact();
    app.fiiContactForm(new ContactDate("1", "2", "3"));
    app.sumbitContactCreation();
    app.goToContactPage();
  }

}
