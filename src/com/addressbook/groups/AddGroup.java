package com.addressbook.groups;

import com.thoughtworks.selenium.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

public class AddGroup extends SeleneseTestCase {
    GroupManager manager;
    Selenium selenium;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
        this.selenium = super.selenium;
    }

    public void addGroup(GroupData data) throws Exception {
        manager = new GroupManager(selenium);

        manager.gotoGroupPage();

        manager.addGroup(data);
        selenium.waitForPageToLoad("30000");
        assertTrue(manager.isTextExist(data.name));
    }

    public GroupData getGroupData() {
        Random rnd = new Random();
        GroupData data = new GroupData();
        data.name = "name" + rnd.nextInt();
        data.header = "header" + rnd.nextInt();
        data.footer = "footer" + rnd.nextInt();
        return data;
    }

    @Test
    public void testAddGrooup() throws Exception {
        addGroup(getGroupData());
    }
}
