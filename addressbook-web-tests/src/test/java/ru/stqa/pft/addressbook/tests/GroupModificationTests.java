package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().groups().size() == 0 ){
        app.goTo().groupPage();
        app.group().create(new GroupDate().withName("test1"));
        }
    }
    @Test
    public  void testGroupModification(){
        Groups before = app.db().groups();
        GroupDate modifietedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withtId(modifietedGroup.getId()).withName("2").withHeader("2").withFooter("2").withFooter("3");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat((app.group().count()),equalTo(before.size()));
        Groups after =app.db().groups();
        assertThat(after, CoreMatchers.equalTo(before.without(modifietedGroup).withAdded(group)));
        verifyGroupListInUI();
    }




}
