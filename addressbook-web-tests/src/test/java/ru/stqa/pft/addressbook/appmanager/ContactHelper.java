package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void sumbitContactCreation() {
        click(By.name("submit"));
    }

    public void fiiContactForm(ContactDate contactDate, boolean creation) {
        type(contactDate.getFistname(), By.name("firstname"));
        type(contactDate.getMiddlename(), By.name("middlename"));
        type(contactDate.getLastname(), By.name("lastname"));

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        }
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void returnContactPage() {
        click(By.linkText("home"));
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void closeAlertForWindowsContact() {
      wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void sumbitContactModification() {
        click(By.name("update"));
    }
}
