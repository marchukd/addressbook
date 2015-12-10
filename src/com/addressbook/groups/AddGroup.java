package com.addressbook.groups;

import com.addressbook.AppManager;
import com.thoughtworks.selenium.*;
import org.junit.Before;
import org.junit.Test;

public class AddGroup extends SeleneseTestCase {
    AppManager manager;
    Selenium selenium;

    public AddGroup(Selenium selenium) {
        this.selenium = selenium;
    }

    @Before
    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
        this.selenium = super.selenium;
    }

    public AddGroup(String name) {
        super(name);
    }

    @Test
    public void testAddGrooup() throws Exception {
        manager = new AppManager(selenium);
        manager.addGroup(manager.getTestGroupData());
    }
}
