package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.util.List;

public class GroupDataGeneration {

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupDate> group = generateGroups(count);
    }
}
