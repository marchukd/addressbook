package com.addressbook.groups;

import com.addressbook.abonents.AbonentData;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/**
 * Created by Dmytro on 16.11.2015.
 */
public class GroupManager extends SeleneseTestCase {
    Selenium selenium;

    GroupManager(Selenium selenium) {
        this.selenium = selenium;
    }

    public void gotoGroupPage() {
        selenium.open("/");
        selenium.click("link=groups");
        selenium.waitForPageToLoad("30000");
    }

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
    }


    void addGroup(GroupData data) {
        selenium.click("name=new");
        selenium.waitForPageToLoad("30000");
        selenium.type("name=group_name", data.name);
        selenium.type("name=group_header", data.header);
        selenium.type("name=group_footer", data.footer);
        clickOnSubmitButton();
        gotoGroupPageAfterAdd();
    }

    void clickOnSubmitButton() {
        selenium.click("name=submit");
        selenium.waitForPageToLoad("30000");
    }

    void gotoGroupPageAfterAdd() {
        selenium.waitForPageToLoad("30000");
        selenium.click("link=group page");
    }

    int getRecordsCount() {
        selenium.waitForPageToLoad("30000");
        return selenium.getXpathCount("//input[@type='checkbox']").intValue();
    }

    boolean isTextExist(String text) {
        return selenium.isTextPresent(text);
    }

    public void gotoGroupPageAfterDelete() {
        selenium.waitForPageToLoad("30000");
        selenium.click("link=group page");
    }

    public GroupData getTestGroupData() {
        GroupData gData = new GroupData();
        gData.name = "testGroupName";
        gData.header = "testHeader";
        gData.footer = "testFooter";
        return gData;
    }
}
