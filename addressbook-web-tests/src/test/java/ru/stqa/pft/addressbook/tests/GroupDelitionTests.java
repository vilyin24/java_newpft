package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupDate("1", null, null));
    }
  }
  @Test
  public void testGroupDelition() throws Exception {

      List<GroupDate> before = app.group().list();
      int index = before.size() - 1;
    app.group().delete(index);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before,after);
  }

}
