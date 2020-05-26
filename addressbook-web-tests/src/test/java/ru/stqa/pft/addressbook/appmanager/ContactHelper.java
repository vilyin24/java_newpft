package ru.stqa.pft.addressbook.appmanager;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void sumbitContactCreation() {
        click(By.name("submit"));
    }

    public void fiiContactForm(ContactDate contactDate,boolean creation) {
        type(By.name("firstname"), contactDate.getFistname());
        type(By.name("middlename"), contactDate.getMiddlename());
        type(By.name("lastname"), contactDate.getLastname());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        }
        else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void closeAlertForWindowsContact() {
      wd.switchTo().alert().accept();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        ;
    }

    public void ininContactModification() {
            click(By.xpath("//img[@alt='Edit']"));
    }
    public void submitContactModification() {
        click((By.xpath("(//input[@name='update'])[2]")));
    }

    public void createContact(ContactDate contact, boolean b) {
        initContact();
        fiiContactForm(contact,true);
        sumbitContactCreation();
        returnToContactPage();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> getContactList() {
        List<ContactDate> contacts = new ArrayList<ContactDate>();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements ){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            ContactDate contact = new ContactDate(lastname,null,null,null);
           contacts.add(contact);
        }

        return contacts;
    }
}


