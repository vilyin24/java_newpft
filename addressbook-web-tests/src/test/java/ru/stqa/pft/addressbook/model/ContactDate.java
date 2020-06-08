package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
    private  String fistname;
    private  String middlename;
    private  String lastname;
    private String group;
    private  int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDate that = (ContactDate) o;
        return id == that.id &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, id);
    }

    public  ContactDate withFistname(String fistname) {
        this.fistname = fistname;
        return this;
    }

    public ContactDate withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactDate withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDate withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactDate withtId(int id) {
        this.id = id;
        return this;
    }


    public int getId() {
        return id;
    }


    public String getFistname() {
        return fistname;
    }

    public String getMiddlename() {
        return middlename;
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }
}
