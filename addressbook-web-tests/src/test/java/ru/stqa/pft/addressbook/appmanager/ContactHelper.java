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
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        attach(By.name("photo"),contactDate.getPhoto());

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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public  ContactDate infoFromEdition(ContactDate contact){
        ininContactModificationByid(contact.getId());
        String firtname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
       return new ContactDate().withtId(contact.getId()).withFistname(firtname).withLastname(lastname).
               withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).
               withEmail(email).withEmail2(email2).withEmail3(email3);
    }


    public void ininContactModificationByid(int  id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value ='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List <WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

       // wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
   }
    public void submitContactModification() {
        click((By.xpath("(//input[@name='update'])[2]")));
    }


    public void create(ContactDate contact, boolean b) {
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

    public Contacts all() {
        Contacts contacts = new Contacts();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements ){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firsttname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String allemails = cells.get(4).getText();
            contacts.add(new ContactDate().withtId(id).withLastname(lastname).withFistname(firsttname)
                    .withAllPhones(allPhones).withallemails(allemails));
        }

        return contacts;
    }
    public void modify( ContactDate contact) {
        selectContactById(contact.getId());
        ininContactModificationByid(contact.getId());
        fiiContactForm((contact),false);
        submitContactModification();
        returnToContactPage();
    }

    public void delete(ContactDate contact) {
        selectContactById(contact.getId());
        deleteContact();
        closeAlertForWindowsContact();
        returnToContactPage();
    }
}


