package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToContactPage();
        if(!app.getContactHelper().isThereAGroup2()){
            app.getContactHelper().createContact(new ContactDate("1", "2", "3","1"),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().ininContactModification();
        app.getContactHelper().fiiContactForm(new ContactDate("1", "4", "5",null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }
}
