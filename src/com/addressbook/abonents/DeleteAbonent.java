package com.addressbook.abonents;

import com.thoughtworks.selenium.*;
import org.junit.Test;

public class DeleteAbonent extends SeleneseTestCase {
    AbonentManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    @Test
    public void testDeleteSingleAbonent() throws Exception {
        manager = new AbonentManager(selenium);
        manager.gotoHomePage();
        int countAbonentBefore = manager.getRecordsCount();
        new AddAbonent(selenium).addAbonent();
        selenium.click("xpath=(//img[@alt='Edit'])[" + countAbonentBefore + "]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//input[@name='update'])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=home page");
        assertEquals(countAbonentBefore, manager.getRecordsCount());
    }
}
