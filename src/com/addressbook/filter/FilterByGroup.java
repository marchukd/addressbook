package com.addressbook.filter;

import com.addressbook.AppManager;
import com.addressbook.abonents.AddAbonent;
import com.addressbook.groups.GroupData;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.junit.Test;

public class FilterByGroup extends SeleneseTestCase {
    private AppManager manager;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    @Test
    public void testFilterByGroup() throws Exception {
        manager = new AppManager(selenium);
        GroupData data1 = new GroupData();
        data1.name = "filterGroup1";
        manager.addGroup(data1);
        manager.gotoHomePage();
        new AddAbonent(selenium).testAddAbonent(1, "filter");
        manager.moveToGroup();

        assertEquals(new AppManager(selenium).getRecordsCount() - 1, 1);
    }
}
