package com.addressbook.groups;

import com.addressbook.AppManager;
import com.thoughtworks.selenium.*;

public class DeleteGroup extends SeleneseTestCase {
    AppManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    public void testDeleteSingleGroup() throws Exception {
        manager = new AppManager(selenium);

        selenium.open("/group.php");
        int recordCountBefore = manager.getRecordsCount();
        manager.addGroup(manager.getTestGroupData());
        manager.deleteGroup(manager.getTestGroupData().name);

        assertEquals(manager.getRecordsCount(), recordCountBefore);
    }
}
