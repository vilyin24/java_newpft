package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDate {
    private final String name;
    private final String header;
    private final String footer;

    public void setId(int id) {
        this.id = id;
    }

    private  int id;


    @Override
    public String toString() {
        return "GroupDate{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int  getId() {
        return id;
    }

    public GroupDate(int  id, String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return id == groupDate.id &&
                Objects.equals(name, groupDate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public GroupDate(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = 0;
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
}
