package com.addressbook.abonents;

import com.thoughtworks.selenium.*;
import org.junit.Test;

public class AddAbonent extends SeleneseTestCase {
    private AbonentManager manager;
    private Selenium selenium;

    public AddAbonent(Selenium selenium) {
        super();
        this.selenium = selenium;
    }

    public AddAbonent(String name) {
        super(name);
    }

    private String wait = "30000";
    private int countAddMultipleAbonent = 2;

    public void setUp() throws Exception {
        setUp("http://addressbook/", "*chrome");
        this.selenium = super.selenium;
    }

    @Test
    public void testAddSingleAbonent() throws Exception {
        manager = new AbonentManager(selenium);

        manager.gotoHomePage();
        int recordSizeBefore = manager.getRecordsCount();
        addAbonent();
        assertEquals(manager.getRecordsCount(), recordSizeBefore + 1);
    }

    @Test
    public void testAddMultipleAbonents() throws Exception {
        manager = new AbonentManager(selenium);
        manager.gotoHomePage();
        int recordSizeBefore = manager.getRecordsCount();
        for (int i = 0; i < countAddMultipleAbonent; i++) {
            addAbonent();
        }
        assertEquals(manager.getRecordsCount(), recordSizeBefore + countAddMultipleAbonent);
    }

    public void addAbonent() {
        openAddNewPage();
        AbonentData data = getTestAbonentData();
        fillForm(data);
        clickSubmit();
    }

    public void clickSubmit() {
        selenium.click("name=submit");
        selenium.waitForPageToLoad(wait);
        selenium.click("link=home page");
        selenium.waitForPageToLoad(wait);
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

    public void openAddNewPage() {
        //selenium.open("/edit.php");
        selenium.click("link=add new");
        selenium.waitForPageToLoad(wait);
    }

    public AbonentData getTestAbonentData() {
        AbonentData aData = new AbonentData();
        aData.firstName = "Dima";
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

}
