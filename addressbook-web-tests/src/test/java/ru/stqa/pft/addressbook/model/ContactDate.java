package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name ="addressbook")
public class  ContactDate {
    @Id
    @Column(name ="id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name ="firstname")
    private  String firstname;

    @Expose
    @Column(name ="middlename")
    private  String middlename;

    @Expose
    @Column(name ="lastname")
    private  String lastname;
    //@Expose

    @Transient
    private String group;

    @Column(name ="home")
    @Type(type = "text")
    private String homePhone;

    @Column(name ="mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Type(type = "text")
    @Column(name ="work")
    private String workPhone;

    @Transient
    private String allPhones;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Column(name ="photo")
    @Type(type = "text")
    private String photo;

    @Transient
    private String allEmails;

    public File getPhoto() {
        return new File (photo);
    }

    public ContactDate withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

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
        this.firstname = fistname;
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

    public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }


}
