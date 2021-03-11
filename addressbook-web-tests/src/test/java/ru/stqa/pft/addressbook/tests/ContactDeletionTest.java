package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withLastname("test1").withGroup("test1"));
    }
  }
  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);
    Set<ContactDate> after = app.contact().all();
    assertThat(app.contact().count(),equalTo(before.size()- 1));
    assertThat(after, equalTo(before.without(deletedContact)));

  }



}
