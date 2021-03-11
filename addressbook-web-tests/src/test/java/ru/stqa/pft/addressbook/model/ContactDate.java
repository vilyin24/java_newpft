package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class  ContactDate {
    private  int id;
    private  String fistname;
    private  String middlename;
    private  String lastname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;

    public String getAllEmails() {
        return allEmails;
    }

    public ContactDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    private String allEmails;

    public String getEmail() {
        return email;


    }
    public ContactDate witEmail(String email){
        this.email = email;
        return this;
    }
    public String getEmail2() {
        return email2;
    }
    public ContactDate witEmail2(String email2){
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }
    public ContactDate witEmail3(String email3){
        this.email3 = email3;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }
    public ContactDate witHomePhone(String homePhone){
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }
    public ContactDate witMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public ContactDate witWorkPhone(String workPhone){
        this.workPhone = workPhone;
        return this;
    }


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

    public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }


}
