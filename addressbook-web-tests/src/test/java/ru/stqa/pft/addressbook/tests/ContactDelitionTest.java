package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDelitionTest extends TestBase {

  @Test
  public void contactDelitionTests() throws Exception {
    app.getNavigationHelper().goToContactPage();
    if(!app.getContactHelper().isThereAGroup2()){
    app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertForWindowsContact();
    app.getContactHelper().returnToContactPage();
  }

}
