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

import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0){
            app.group().create(new GroupDate().withName("test1"));
        }
    }
    @Test
    public  void testGroupModification(){
        Groups before = app.group().all();
        GroupDate modifietedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withtId(modifietedGroup.getId()).withName("2").withHeader("2").withFooter("2").withFooter("3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size());
        assertThat(after, CoreMatchers.equalTo(before.without(modifietedGroup).withAdded(group)));
    }


}
