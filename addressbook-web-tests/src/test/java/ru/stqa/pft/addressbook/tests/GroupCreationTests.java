package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends  TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
      GroupDate group = new GroupDate().withName("test1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size()+1));

    assertThat(after,equalTo(
            before.withAdded(group.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
