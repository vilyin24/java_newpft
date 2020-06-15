package ru.stqa.pft.addressbook.tests;

import org.checkerframework.checker.units.qual.s;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests  extends  TestBase{


    @Test()
    public void testContactPhones(){
        app.getcontact().returnToContactPage();
        ContactDate contact = app.getcontact().total().iterator().next();
        ContactDate contactInfoFromEditForm = app.getcontact().infoFromEdition(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }

    private String mergePhones(ContactDate contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).stream()
                .filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static  String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");

    }
}
