package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fiiContactForm(new ContactDate("55","44","22"));
        app.getContactHelper().sumbitContactModification();
        app.getGroupHelper().returnGroupPage();
    }
    }

