package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactDate().withLastname("test1").withGroup("test1"));
    }
  }
  @Test
  public void testContactDeletion() throws Exception {
    List<ContactDate> before = app.contact().list();
    int index = before.size()- 1;
    app.contact().delete(index);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(index);
    Assert.assertEquals(before,after);
  }



}
