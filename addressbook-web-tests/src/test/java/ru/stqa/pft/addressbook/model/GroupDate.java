package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDate {
    private final String id;
    private final String name;
    private final String header;
    private final String footer;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return Objects.equals(id, groupDate.id) &&
                Objects.equals(name, groupDate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public GroupDate(String id, String name, String header, String footer) {
        this.name = name;
        this.id = id;
        this.header = header;
        this.footer = footer;
    }
    public GroupDate(String name, String header, String footer) {
            this.name = name;
            this.id = null;
            this.header = header;
            this.footer = footer;
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
