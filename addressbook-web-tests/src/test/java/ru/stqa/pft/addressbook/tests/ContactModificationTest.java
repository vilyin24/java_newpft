package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("test1", null, null, "test1"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactDate> before = app.getContactHelper().getContactList();
        int index =before.size()- 1;
        ContactDate contact = new ContactDate(before.get(index).getId(),"55","44","4",null);
        app.getContactHelper().modifyContact(index, contact);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactDate> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}

