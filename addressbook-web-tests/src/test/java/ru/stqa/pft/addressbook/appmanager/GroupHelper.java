package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupHelper  extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }
    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(groupDate.getName(), By.name("group_name"));
        type( groupDate.getHeader(),By.name("group_header"));
        type(groupDate.getFooter(), By.name("group_footer"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnGroupPage() {
        click(By.linkText("groups"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
            click(By.name("edit"));
        }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}

