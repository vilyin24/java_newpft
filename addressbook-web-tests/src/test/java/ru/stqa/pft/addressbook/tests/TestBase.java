package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {

    protected static  final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public  void logTestStart(Method m, Object [] p){
        logger.info("Start test" + m.getName() +"with parameters" + Arrays.asList(p));


    }
    @AfterMethod(alwaysRun = true)
    public  void logTestStop(Method m) {
        logger.info("Stop test" + m.getName());
    }

    public void verifyGroupListInUI() {
        if(Boolean.getBoolean("verifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g)-> new GroupDate().withtId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }

    }
    public void verifyContactListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uIContacts = app.contact().all();
            assertThat(uIContacts, equalTo(dbContacts.stream()
                    .map((g) -> new ContactDate().withtId(g.getId()).withLastname(g.getLastname()))
                    .collect(Collectors.toSet())));
        }
    }
}
