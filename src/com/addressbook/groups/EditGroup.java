package com.addressbook.groups;

import com.addressbook.AppManager;
import com.thoughtworks.selenium.*;

public class EditGroup extends SeleneseTestCase {
    AppManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    public void testEditGroup() throws Exception {
        manager = new AppManager(selenium);
        manager.gotoGroupPage();

        GroupData gData = manager.getTestGroupData();
        AddGroup addGroup = new AddGroup(selenium);
        addGroup.selenium = selenium;
        manager.addGroup(gData);
        manager.gotoGroupPage();
        selenium.click("xpath=(//input[contains(@title, 'Select (" + manager.getTestGroupData().name + ")')])");
        selenium.click("name=edit");
        selenium.waitForPageToLoad("30000");

        gData.name += "Changed";
        gData.header += "Changed";
        gData.footer += "Changed";

        selenium.type("name=group_name", gData.name);
        selenium.type("name=group_header", gData.header);
        selenium.type("name=group_footer", gData.footer);

        selenium.click("name=update");
        manager.gotoGroupPage();
        assertTrue(manager.isTextExist(gData.name));
    }
}
