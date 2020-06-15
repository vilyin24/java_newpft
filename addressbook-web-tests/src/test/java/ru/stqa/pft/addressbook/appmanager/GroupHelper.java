package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase{
    public GroupHelper(WebDriver wd) {
        super(wd);
    }


    public void submitGroupCreation() {
      click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());


    }

    private Groups groupCache = null;



    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroupByid(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }



    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitModification() {
        click(By.name("update"));
    }

    public void create(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }
    public void modify(GroupDate group) {
        selectGroupByid(group.getId());
       initGroupModification();
       fillGroupForm(group);
       submitModification();
        groupCache = null;
       returnToGroupPage();
    }

    public void delete(GroupDate group) {
        selectGroupByid(group.getId());
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }
    public boolean isThereAGroup() {
     return isElementPresent(By.name("selected[]"));
    }

    public int count() {
     return wd.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        if(groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List <WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupDate().withtId(id).withName(name));
        }
        return new Groups(groupCache);
    }
}

