package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
   try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/ru/stqa/pft/addressbook/resources/contact.xml")))) {
       String xml = "";
       String line = reader.readLine();
       while (line != null) {
           xml += line;
           line = reader.readLine();
       }
       XStream xStream = new XStream();
       xStream.processAnnotations(ContactDate.class);
       List<ContactDate> contacts = (List<ContactDate>) xStream.fromXML(xml);
       return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
   }
  }
    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactDate> contacts = gson.fromJson(json, new TypeToken<List<ContactDate>>() {
            }.getType());
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactDate contact) throws Exception {
    //String []names = new String[] {"test1", "test2","test3"};
     //File photo = new File("src/test/java/ru/stqa/pft/addressbook/resources/1.png");
      Groups groups = app.db().groups();
      app.goTo().contactPage();
      Contacts before = app.db().contacts();
      app.contact().create(contact.inGroup(groups.iterator().next()));
      Contacts  after = app.db().contacts();
      assertThat(after.size(),equalTo(before.size() + 1));

      assertThat(after, equalTo(
              before.withAdded(contact.withtId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
      verifyContactListInUI();

  }

}
