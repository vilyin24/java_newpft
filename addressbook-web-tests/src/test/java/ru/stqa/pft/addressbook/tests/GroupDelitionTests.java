package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size() == 0){
      app.group().create(new GroupDate().withName("test1"));
    }
  }
  @Test
  public void testGroupDelition() throws Exception {

     Groups before = app.group().all();
     GroupDate delitedGroup = before.iterator().next();
     app.group().delete(delitedGroup);
    assertThat((app.group().count()),equalTo(before.size()-1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(delitedGroup)));

  }

}
