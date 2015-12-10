package com.addressbook;

import com.addressbook.abonents.AbonentData;
import com.addressbook.groups.GroupData;
import com.thoughtworks.selenium.Selenium;

public class AppManager {
    Selenium selenium;
    public String wait = "30000";

    public AppManager(Selenium selenium) {
        this.selenium = selenium;
    }

    public int getRecordsCount() {
        selenium.waitForPageToLoad(wait);
        return selenium.getXpathCount("//input[@type='checkbox']").intValue();
    }

    public void gotoHomePage() {
        selenium.open("/");
        selenium.click("link=home");
        selenium.waitForPageToLoad("30000");
    }

    public void fillForm(AbonentData data) {
        selenium.waitForPageToLoad(wait);
        selenium.type("name=firstname", data.firstName);
        selenium.type("name=lastname", data.lastName);
        selenium.type("name=address", data.addressOne);
        selenium.type("name=home", data.homeNumber);
        selenium.type("name=mobile", data.mobileNumber);
        selenium.type("name=work", data.workNumber);
        selenium.type("name=email", data.emailOne);
        selenium.type("name=email2", data.emailSecond);
        selenium.select("name=bday", "label=" + data.bDay);
        selenium.select("name=bmonth", "label=" + data.bMonth);
        selenium.type("name=byear", data.bYear);
        selenium.select("name=new_group", "label=" + data.group);
        selenium.type("name=address2", data.addressSecond);
        selenium.type("name=phone2", "hoooooooooome");
    }

    public void clickSubmit() {
        selenium.click("name=submit");
        selenium.waitForPageToLoad(wait);
        selenium.click("link=home page");
        selenium.waitForPageToLoad(wait);
    }

    public AbonentData getTestAbonentData(String fname) {
        AbonentData aData = new AbonentData();
        aData.firstName = fname;
        aData.lastName = "Marchuk";
        aData.addressOne = "addressOne";
        aData.homeNumber = "0676624312";
        aData.mobileNumber = "0988007854";
        aData.workNumber = "9379992";
        aData.emailOne = "marchukd@gmail.com";
        aData.emailSecond = "ganja@mail.ru";
        aData.bDay = "16";
        aData.bMonth = "November";
        aData.bYear = "1994";
        aData.group = "Rob";
        aData.addressSecond = "addressSecond";
        return aData;
    }

    public void openAddNewPage() {
        selenium.click("link=add new");
        selenium.waitForPageToLoad(wait);
    }

    public void clickDeleteButton() {
        selenium.click("xpath=(//input[@name='update'])[2]");
        selenium.waitForPageToLoad("30000");
    }

    public void clickButtonEditAbonent(int countAbonentBefore) {
        selenium.click("xpath=(//img[@alt='Edit'])[" + countAbonentBefore + "]");
        selenium.waitForPageToLoad("30000");
    }

    public void moveToGroup() {
        selenium.click("xpath=(//input[contains(@title, 'Select (filter Marchuk)')])");
        selenium.click("name=add");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=group page \"filterGroup1\"");
        selenium.waitForPageToLoad("30000");
    }

    //For Groups
    public void gotoGroupPage() {
        selenium.open("/");
        selenium.click("link=groups");
        selenium.waitForPageToLoad("30000");
    }

    public void addGroup(GroupData data) {
        gotoGroupPage();
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

    public boolean isTextExist(String text) {
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

    public void deleteGroup(String name) {
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//input[contains(@title, 'Select (" + name + ")')])");
        selenium.click("name=delete");
        gotoGroupPageAfterDelete();
    }
}
