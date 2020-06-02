package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDelitionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.getcontact().list().size() == 0) {
      app.getcontact().create(new ContactDate("1", "2", "1", "1"), true);
    }
  }
  @Test
  public void contactDelitionTests() throws Exception {
    List<ContactDate> before = app.getcontact().list();
    app.getcontact().delete(before.size() -1);
    List<ContactDate> after = app.getcontact().list();

    before.remove(before.size() -1);
    Assert.assertEquals(before.size(),after.size());
  }

}
