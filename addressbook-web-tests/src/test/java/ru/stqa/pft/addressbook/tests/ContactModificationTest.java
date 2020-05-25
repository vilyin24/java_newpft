package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToContactPage();
        int before = app.getContactHelper().getContactCount();
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().ininContactModification();
        app.getContactHelper().fiiContactForm(new ContactDate("1", "4", "5",null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before );
    }
}
