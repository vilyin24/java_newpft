package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
    private final int id;
    private final String fistname;
    private final String middlename;
    private final String lastname;
    private String group;

    public ContactDate(int id,String fistname, String middlename, String lastname,String group) {
        this.id = id;
        this.fistname = fistname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public ContactDate(String fistname, String middlename, String lastname, String group) {
        this.id = 0;
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
