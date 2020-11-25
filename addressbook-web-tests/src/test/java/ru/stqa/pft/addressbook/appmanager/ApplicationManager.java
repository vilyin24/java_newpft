package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper ;
    private  GroupHelper groupHelper;
    private  ContactHelper contactHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin","secret");
    }


    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    public boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
    }

