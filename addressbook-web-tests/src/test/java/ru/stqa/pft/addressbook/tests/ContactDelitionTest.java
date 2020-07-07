package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactDelitionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.getcontact().all().size() == 0) {
      app.getcontact().create(new ContactDate().withFistname("1").withLastname("1").withMiddlename("2").withGroup("1"), true);
    }
  }
  @Test
  public void contactDelitionTests() throws Exception {
    Contacts before = app.getcontact().all();
    ContactDate delitedContact = before.iterator().next();
    app.getcontact().delete(delitedContact);
    Contacts after = app.getcontact().all();
    assertEquals(after.size(), before.size()-1);
    assertThat(after, equalTo(before.without(delitedContact)));

  }

}
