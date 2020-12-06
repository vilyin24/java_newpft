package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private final String fistname;
    private final String middlename;
    private final String lastname;
    private String group;

    public ContactDate(String fistname, String middlename, String lastname,String group) {
        this.fistname = fistname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
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

    public String getGroup() {
        return group;
    }
}
