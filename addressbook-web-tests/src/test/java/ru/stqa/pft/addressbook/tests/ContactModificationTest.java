package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToContactPage();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactDate("test1",null,"3","test1"));
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()- 1);
        app.getContactHelper().initContactModification(before.size()- 1);
        ContactDate contact = new ContactDate(before.get(before.size()- 1).getId(),"55","44","4",null);
        app.getContactHelper().fiiContactForm(contact,false);
        app.getContactHelper().sumbitContactModification();
        app.getContactHelper().returnContactPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
    }

