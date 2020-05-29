package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
    private final String fistname;
    private final String middlename;
    private final String lastname;
    private String group;
    private  int id;



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public ContactDate(int id, String fistname, String middlename, String lastname, String group) {
        this.fistname = fistname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
        this.id = id;
    }
    public ContactDate( String fistname, String middlename, String lastname, String group) {
        this.fistname = fistname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
        this.id = 0 ;
    }

    public String getFistname() {
        return fistname;
    }

    public String getMiddlename() {
        return middlename;
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
        return Objects.hash(lastname, id);
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
