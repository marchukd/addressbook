package com.addressbook.abonents;

import com.thoughtworks.selenium.*;
import org.junit.Test;

public class DeleteAbonent extends SeleneseTestCase {
    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }

    @Test
    public void testDeleteSingleAbonent() throws Exception {
        AbonentManager.clickHome(selenium);
        int countAbonentBefore = AbonentManager.getRecordsCount(selenium);
        new AddAbonent(selenium).AddNewAbonent();
        selenium.click("xpath=(//img[@alt='Edit'])[" + countAbonentBefore + "]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//input[@name='update'])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=home page");
        assertEquals(countAbonentBefore, AbonentManager.getRecordsCount(selenium));
    }
}
