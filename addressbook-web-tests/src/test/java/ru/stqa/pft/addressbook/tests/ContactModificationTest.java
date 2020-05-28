package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToContactPage();
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactDate("1", "2", "1","1"),true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().ininContactModification(before.size() - 1);
        ContactDate contact =new ContactDate(before.get(before.size()-1).getId(), "7", "5","1","1");
        app.getContactHelper().fiiContactForm((contact),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();

        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() );

       before.remove(before.size() - 1);
       before.add(contact);

        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }
}
