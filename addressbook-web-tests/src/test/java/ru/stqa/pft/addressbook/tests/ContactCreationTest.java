package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest  extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    ContactDate contact =  new ContactDate("test1",null,"1","test1");
    app.getContactHelper().createContact(contact);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);

    before.add(contact);
    int max = 0 ;
    for(ContactDate c : after){
      if(c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);

    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
