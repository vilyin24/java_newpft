package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupModificationTests extends  TestBase {


    @Test
    public  void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupDate("1", "2", "3"));
        app.getGroupHelper().submitModification();
        app.getGroupHelper().returnToGroupPage();

    }

}
