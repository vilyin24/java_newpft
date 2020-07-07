package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactDate {
    private  String fistname;
    private  String middlename;
    private  String lastname;
    private  String mobilePhone;
    private  String homePhone;
    private  String workPhone;
    private  String allPhones;
    private String group;
    private String email;
    private String email2;
    private String email3;
    private String allemails;
    private int id = Integer.MAX_VALUE;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactDate withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactDate withallemails(String allemails) {
        this.allemails = allemails;
        return this;
    }

    public String getallemails() {
        return allemails;
    }

    public String getAllPhones() {
        return allPhones;
    }


    public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactDate withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactDate withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactDate withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDate withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
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
