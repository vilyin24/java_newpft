package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  ContactHelper contactHelper ;

    private  GroupHelper groupHelper ;
    private String browser;
    private DbHelper dbHelper;


    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new Properties();



    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        dbHelper = new DbHelper();

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }
        else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }
        else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();

        }


        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"),properties.getProperty("web.adminPassword"));

        dbHelper = new DbHelper();
    }

    public void stop() {
        wd.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper getcontact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public DbHelper db(){
        return dbHelper;
    }
}
