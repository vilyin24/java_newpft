package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactDate {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private  String firstname;

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Expose
    @Column(name = "middlename")
    private  String middlename;

    @Expose
    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobilePhone;

    @Column(name = "home")
    @Type(type = "text")
    private  String homePhone;

    @Column(name = "work")
    @Type(type = "text")
    private  String workPhone;

    @Transient
    private  String allPhones;
    @Transient
    private String group;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allemails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;


    public File getPhoto() {
        return new File(photo);
    }

    public ContactDate withPhoto(File photo) {
        this.photo = photo.getPath();
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
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname);
    }

    public  ContactDate withFistname(String firstname) {
        this.firstname = firstname;
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


    public String getFirstname() {
        return firstname;
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
