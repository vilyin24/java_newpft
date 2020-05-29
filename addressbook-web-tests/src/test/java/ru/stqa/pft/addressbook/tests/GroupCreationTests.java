package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends  TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
      List<GroupDate> before = app.getGroupHelper().getGroupList();
      GroupDate group = new GroupDate("1",null,null);
    app.getGroupHelper().createGroup(group);
      List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);


    int max = 0;
    for(GroupDate g : after){
      if(g.getId() > max){
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
  }

}
