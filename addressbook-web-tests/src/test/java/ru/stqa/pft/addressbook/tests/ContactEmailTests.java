package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests  extends TestBase{

    @Test()
    public void testContactEmails(){
        app.getcontact().returnToContactPage();
        ContactDate contact = app.getcontact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.getcontact().infoFromEdition(contact);

        assertThat(contact.getallemails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    }

    private String mergeEmails(ContactDate contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream()
                .filter((s) -> ! s.equals("")).map(ContactEmailTests::cleaned)
               .collect(Collectors.joining("\n"));

    }

    public static  String cleaned(String email){
        return  email.trim();
    }

    }


