package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupDelitionTests extends TestBase {



  @Test
  public void testGroupDelition() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupDate("1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
