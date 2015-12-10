package com.addressbook.abonents;

import com.addressbook.AppManager;
import com.thoughtworks.selenium.*;
import org.junit.Test;

public class AddAbonent extends SeleneseTestCase {
    private AppManager manager;
    private Selenium selenium;

    public AddAbonent(Selenium selenium) {
        super();
        this.selenium = selenium;
    }

    public AddAbonent(String name) {
        super(name);
    }

    private String wait = "30000";

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
        this.selenium = super.selenium;
    }

    @Test
    public void testAddSingleAbonent() throws Exception {
        testAddAbonent(1, "Dima");
    }

    @Test
    public void testAddMultipleAbonents() throws Exception {
        testAddAbonent(2, "Dima");
    }

    public void testAddAbonent(int countAddAbonent, String fname) {
        manager = new AppManager(selenium);
        manager.gotoHomePage();
        int recordSizeBefore = manager.getRecordsCount();
        for (int i = 0; i < countAddAbonent; i++) {
            manager.openAddNewPage();
            AbonentData data = manager.getTestAbonentData(fname);
            manager.fillForm(data);
            manager.clickSubmit();
        }
        assertEquals(manager.getRecordsCount(), recordSizeBefore + countAddAbonent);
    }
}
