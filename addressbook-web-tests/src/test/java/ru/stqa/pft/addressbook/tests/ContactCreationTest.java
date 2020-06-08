package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.getcontact().total();
    ContactDate contact =new ContactDate().withFistname("1").withLastname("1").withMiddlename("2").withGroup("1").withGroup("1");
    app.getcontact().create(contact,true);
    Contacts  after = app.getcontact().total();
    assertThat(after.size(),equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withtId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }

}
