package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactDate().withLastname("test1").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactDate> before = app.contact().list();
        int index =before.size()- 1;
        ContactDate contact = new ContactDate().withId(before.get(index).getId()).withLastname("test1").withFistname("22").withGroup("test1");
        app.contact().modify(index, contact);
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactDate> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}

