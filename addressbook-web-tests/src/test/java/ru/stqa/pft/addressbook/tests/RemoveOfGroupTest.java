package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class RemoveOfGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsContacts() {
        app.goTo().contactPage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFistname("1").withMiddlename("2").withLastname("4"));
        }
    }
    @BeforeMethod
    public void ensurePreconditionsGroups() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("Test1"));
        }
    }

    @Test
    public void testRemoveContactOfGroup() {
        ContactDate contact = app.db().contacts().stream().iterator().next();
        GroupDate group = app.db().groups().stream().iterator().next();

        if(!app.contact().verifyContactInGroup(contact, group)) {                 //Если контакт не в выбранной группе, то добавляем в нее
            app.goTo().contactPage();
            app.contact().addInGroup(contact.getId(),group.getName());
        }
        app.goTo().contactPage();
        app.contact().removeOfGroup(contact.getId(), group.getId());
        app.goTo().contactPage();

        Assert.assertFalse(app.contact().verifyContactInGroup(app.db().contactWithId(contact.getId()), group));
    }
}

