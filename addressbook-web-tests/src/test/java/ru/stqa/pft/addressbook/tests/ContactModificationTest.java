package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.getcontact().list().size() == 0) {
            app.getcontact().create(new ContactDate("1", "2", "1", "1"), true);
        }
    }
    @Test
    public void testContactModification() throws Exception {
        List<ContactDate> before = app.getcontact().list();
        int index = before.size() - 1;
        ContactDate contact =new ContactDate(before.get(index).getId(), "7", "5","1","1");
        app.getcontact().modify(index, contact);
        List<ContactDate> after = app.getcontact().list();
        Assert.assertEquals(after.size(),before.size() );

       before.remove(index);
       before.add(contact);
        Comparator<? super ContactDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }


}
