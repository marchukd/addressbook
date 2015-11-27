package com.addressbook.groups;

import com.thoughtworks.selenium.*;

public class DeleteGroup extends SeleneseTestCase {
    GroupManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    public void testDeleteSingleGroup() throws Exception {
        manager = new GroupManager(selenium);

        selenium.open("/group.php");
        int recordCountBefore = manager.getRecordsCount();
        manager.addGroup(manager.getTestGroupData());
        deleteGroup(manager.getTestGroupData().name);

        assertEquals(manager.getRecordsCount(), recordCountBefore);
        //assertTrue(!manager.isTextExist(manager.getTestGroupData().name));
    }

    public void deleteGroup(String name) {
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//input[contains(@title, 'Select (" + name + ")')])");
        selenium.click("name=delete");
        manager.gotoGroupPageAfterDelete();
    }
}
