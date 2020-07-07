package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.getcontact().all().size() == 0) {
            app.getcontact().create(new ContactDate().withFistname("1").withMiddlename("2").withGroup("1"),true);
        }
    }
    @Test
    public void testContactModification() throws Exception {
        Contacts before = app.getcontact().all();
        ContactDate modifiedContact = before.iterator().next();

        ContactDate contact =new ContactDate().withtId(modifiedContact.getId()).withFistname("1").withLastname("1").withMiddlename("2").withGroup("1");
        app.getcontact().modify(contact);
        Contacts after = app.getcontact().all();
        assertEquals(after.size(),before.size() );

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
