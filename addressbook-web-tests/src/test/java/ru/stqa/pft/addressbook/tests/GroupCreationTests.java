package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends  TestBase{

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/ru/stqa/pft/addressbook/resources/groups.xml")));
    String xml ="";
    String line = reader.readLine();
    while (line != null) {
        xml += line;
        line = reader.readLine();
      }
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupDate.class);
      List<GroupDate >groups =  (List<GroupDate>) xStream.fromXML(xml);
      return  groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupDate group ) throws Exception {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat((app.group().count()),equalTo(before.size()+1));
      Groups after = app.group().all();
      assertThat(after,equalTo(
              before.withAdded(group.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }



  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupDate group = new GroupDate().withName("test1'");
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.group().all();


    assertThat(after,equalTo(before));
  }
}
