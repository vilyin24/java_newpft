package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends TestBase{

@DataProvider
public Iterator<Object[]> validGroups() throws IOException {
  List<Object[]> list = new ArrayList<Object[]>();
  BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/groups.csv")));
  String line = reader.readLine();

  while (line != null){
    String[] split = line.split(";");
    list.add(new Object[] {new GroupDate().withName(split [0]).withHeader(split [1]).withFooter(split [2])});
    line = reader.readLine();
  }
  return list.iterator();
}


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupDate group)  {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }
  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupDate group = new GroupDate().withName("test2'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }

}
