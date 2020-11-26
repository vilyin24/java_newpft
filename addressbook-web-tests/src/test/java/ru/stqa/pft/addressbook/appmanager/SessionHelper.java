package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type(username,By.name("user"));
        type(password,By.name("pass"));
        click(By.xpath("//input[@value='Login']"));
    }
}
