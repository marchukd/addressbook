package com.addressbook.abonents;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by Dmytro on 26.11.2015.
 */
public class AbonentManager {
    Selenium selenium;
    public String wait = "30000";

    public AbonentManager(Selenium selenium) {
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
}
