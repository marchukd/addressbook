package com.addressbook.groups;

import com.thoughtworks.selenium.*;

public class EditGroup extends SeleneseTestCase {
    GroupManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    public void testEditGroup() throws Exception {
        manager = new GroupManager(selenium);
        manager.gotoGroupPage();

        GroupData gData = manager.getTestGroupData();
        new AddGroup(selenium).addGroup(gData);

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
