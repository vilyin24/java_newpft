package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    List<ContactDate> before = app.getcontact().list();
    ContactDate contact =new ContactDate((before.get(before.size()-1).getId()),"1","2","3","1");
    app.getcontact().create(contact,true);
    List<ContactDate> after = app.getcontact().list();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
