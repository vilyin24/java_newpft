package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest  extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactDate.class);
      List<ContactDate> contacts = (List<ContactDate>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/contacts.json")))){
    String json = "";
    String line = reader.readLine();
    while (line != null){
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List <ContactDate> contacts =   gson.fromJson(json,new TypeToken<List<ContactDate>>(){}.getType());
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
  }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactDate contact) throws Exception {
    app.goTo().contactPage();
      Contacts before = app.contact().all();
      app.contact().create(contact);
      assertThat(app.group().count(),equalTo(before.size()+1));
      Contacts after = app.contact().all();


      //contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
      assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
    }




  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactDate contact =  new ContactDate().withLastname("test1'").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();

    //contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    assertThat(after, equalTo(before));
  }
  }


