package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;


public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupDate("1", "2", "3"));
    app.submitGroupCreation();
    app.gotoGroupPage();
  }

}
