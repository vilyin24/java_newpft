package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToContactPage();
        int before =app.getContactHelper().getContactCount();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactDate("test1",null,null,"test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fiiContactForm(new ContactDate("55","44","22",null),false);
        app.getContactHelper().sumbitContactModification();
        app.getContactHelper().returnContactPage();
        int after =app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before);
    }
    }

