package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.getcontact().all();
    File photo = new File("src/test/java/ru/stqa/pft/addressbook/resources/1.png");
    ContactDate contact =new ContactDate().withFistname("1").withLastname("1").withMiddlename("2").withGroup("1").withGroup("1").withPhoto(photo);
    app.getcontact().create(contact,true);
    Contacts  after = app.getcontact().all();
    assertThat(after.size(),equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withtId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }

}
