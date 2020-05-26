package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToContactPage();
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().ininContactModification();
        app.getContactHelper().fiiContactForm(new ContactDate("1", "4", "5",null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() );
    }
}
