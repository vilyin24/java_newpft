package ru.stqa.pft.addressbook.appmanager;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper {
    FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void sumbitContactCreation() {
        click2(By.name("submit"));
    }

    private void click2(By locator) {
        wd.findElement(locator).click();
    }

    public void fiiContactForm(ContactDate contactDate) {
        type2(By.name("firstname"), contactDate.getFistname());
        type2(By.name("middlename"), contactDate.getMiddlename());
        type2(By.name("lastname"), contactDate.getLastname());
    }

    private void type2( By locator, String text) {
        click2(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToContactPage() {
        click2(By.linkText("home"));
    }

    public void initContact() {
        click2(By.linkText("add new"));
    }

    public void closeAlertForWindowsContact() {
      wd.switchTo().alert().accept();
    }

    public void deleteContact() {
        click2(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click2(By.name("selected[]"));
        ;
    }
}
