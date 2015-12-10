package com.addressbook.abonents;

import com.addressbook.AppManager;
import com.thoughtworks.selenium.*;
import org.junit.Test;

public class DeleteAbonent extends SeleneseTestCase {
    AppManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    @Test
    public void testDeleteSingleAbonent() throws Exception {
        manager = new AppManager(selenium);
        manager.gotoHomePage();
        int countAbonentBefore = manager.getRecordsCount() - 1;
        manager.clickButtonEditAbonent(countAbonentBefore);
        manager.clickDeleteButton();
        selenium.click("link=home page");
        assertEquals(countAbonentBefore, manager.getRecordsCount());
    }

    public void deleteAllAbonents() throws Exception {
        selenium.open("/");
        manager = new AppManager(selenium);
        int countOfRecords = manager.getRecordsCount() - 1;
        for (int i = countOfRecords; i > 0; i--) {
            manager.clickButtonEditAbonent(i);
            manager.clickDeleteButton();
            selenium.click("link=home page");
            selenium.waitForPageToLoad("30000");
        }
    }

    @Test
    public void testDeleteAllAbonents() throws Exception {
        selenium.open("/");
        manager = new AppManager(selenium);
        int countOfRecords = manager.getRecordsCount() - 1;
        if (countOfRecords == 0) {
            new AddAbonent(selenium).testAddAbonent(5, "Dima");
        }
        deleteAllAbonents();
        assertEquals(manager.getRecordsCount() - 1, 0);
    }
}
