package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

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
        attach(contactDate.getPhoto(), By.name("photo"));

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


    public void closeAlertForWindowsContact() {
      wd.switchTo().alert().accept();
    }

    public void initContactModification(int id) {
        wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();

    }

    public void sumbitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactDate contact) {
        initContact();
        fiiContactForm(contact,true);
        sumbitContactCreation();
        contactCache = null;
        returnContactPage();
    }
    public void modify(ContactDate contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fiiContactForm(contact,false);
        sumbitContactModification();
        contactCache = null;
        returnContactPage();
    }

    public void delete(ContactDate contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        closeAlertForWindowsContact();
        contactCache = null;
        returnContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
      return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> list() {
        List<ContactDate> contacts = new ArrayList<>();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element: elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            contacts.add(new ContactDate().withId(id).withLastname(lastname));
        }
        return contacts;
    }
    private Contacts contactCache = null;

    public Contacts all() {
        if(contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element: elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            contactCache.add(new ContactDate().withId(id).withLastname(lastname).withAllPhones(allPhones).
                    withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }


    public ContactDate infoFromEditForm(ContactDate contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
         return new ContactDate().withId(contact.getId()).withFistname(firstname).withLastname(lastname)
                 .witHomePhone(home).witMobilePhone(mobile).witWorkPhone(work).
                         witEmail(email).witEmail2(email2).witEmail3(email3);

    }


   private void initContactModificationById(int id){
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
   }
}
