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
        if(app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFistname("1").withMiddlename("2").withGroup("1"),true);
          }
        }
    @Test
    public void testContactModification() throws Exception {
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();

        ContactDate contact =new ContactDate().withtId(modifiedContact.getId()).withFistname("1").withLastname("1").withMiddlename("2").withGroup("1");
        app.goTo().contactPage();
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(),before.size() );

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();

    }



}
