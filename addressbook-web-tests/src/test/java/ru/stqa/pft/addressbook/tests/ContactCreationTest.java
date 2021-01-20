package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest  extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    List<ContactDate> before = app.contact().list();
    ContactDate contact =  new ContactDate().withLastname("test1").withGroup("test1");
    app.contact().create(contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()+1);



    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
  }


