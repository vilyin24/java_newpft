package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDate {
    private final String name;
    private final String header;
    private final String footer;
    private final String id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return Objects.equals(name, groupDate.name) &&
                Objects.equals(id, groupDate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "GroupDate{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public GroupDate(String id, String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }
    public GroupDate( String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = null;
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
