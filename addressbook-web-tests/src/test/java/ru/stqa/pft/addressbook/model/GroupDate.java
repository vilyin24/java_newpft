package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupDate {
    @Expose
    @Column(name = "group_name")
    private  String name;

    @Expose
    @Column(name = "group_header")
    @Type( type = "text")
    private  String header;

    @Expose
    @Column(name = "group_footer")
    @Type( type = "text")
    private  String footer;

    public Set<ContactDate> getContacts() {
        return contacts;
    }

    @ManyToMany(mappedBy = "groups")
    private Set<ContactDate> contacts = new HashSet<ContactDate>();

    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private  int id = Integer.MAX_VALUE;

    public int  getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }


    public GroupDate withtId(int id) {
        this.id = id;
        return this;
    }
    public GroupDate withName(String name) {
        this.name = name;
        return this;
    }

    public GroupDate withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupDate withFooter(String footer) {
        this.footer = footer;
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return id == groupDate.id &&
                Objects.equals(name, groupDate.name) &&
                Objects.equals(header, groupDate.header) &&
                Objects.equals(footer, groupDate.footer);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (footer != null ? footer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupDate{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                ", id=" + id +
                '}';
    }


}
