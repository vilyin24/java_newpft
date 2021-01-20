package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
    private  int id;
    private  String fistname;
    private  String middlename;
    private  String lastname;
    private String group;


    public int getId() {
        return id;

    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                '}';
    }

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
        return Objects.hash(id, lastname);
    }


    public ContactDate withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDate withFistname(String fistname) {
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
