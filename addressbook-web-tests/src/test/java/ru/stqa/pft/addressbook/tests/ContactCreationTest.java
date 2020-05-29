package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    ContactDate contact =new ContactDate((before.get(before.size()-1).getId()),"1","2","3","1");
    app.getContactHelper().createContact(contact,true);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);


    int max = 0;
    for(ContactDate g :after){
      if (g.getId() > max){
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
