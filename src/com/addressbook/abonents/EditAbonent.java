package com.addressbook.abonents;

import com.thoughtworks.selenium.*;

import java.util.Random;

public class EditAbonent extends SeleneseTestCase {
    AbonentManager manager;
    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    public void testEditAbonent() throws Exception {
        manager = new AbonentManager(selenium);
        manager.gotoHomePage();

        selenium.click("css=img[alt=\"Edit\"]");
        selenium.waitForPageToLoad("30000");

        Random random = new Random();
        String suffx = selenium.getValue("name=lastname");
        suffx += String.valueOf(random.nextInt()) + String.valueOf(random.nextInt());

        selenium.type("name=lastname", "");
        selenium.type("name=lastname", suffx);
        selenium.click("name=update");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=home page");
        selenium.waitForPageToLoad("30000");

        assertTrue(selenium.isTextPresent(suffx));
    }
}
