package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase {


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void sumbitContactCreation() {
        click(By.name("submit"));
    }

    public void fiiContactForm(ContactDate contactDate) {
        type(By.name("firstname"), contactDate.getFistname());
        type(By.name("middlename"), contactDate.getMiddlename());
        type(By.name("lastname"), contactDate.getLastname());
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
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
