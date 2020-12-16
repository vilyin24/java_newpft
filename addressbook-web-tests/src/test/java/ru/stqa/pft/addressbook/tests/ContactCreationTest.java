package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTest  extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    int before =app.getContactHelper().getContactCount();
    app.getContactHelper().createContact( (new ContactDate("test1",null,null,"test1")));
    int after =app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);

  }

}
