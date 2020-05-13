package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private final String fistname;
    private final String middlename;
    private final String lastname;

    public ContactDate(String fistname, String middlename, String lastname) {
        this.fistname = fistname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public String getFistname() {
        return fistname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }
}
