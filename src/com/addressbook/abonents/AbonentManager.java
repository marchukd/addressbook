package com.addressbook.abonents;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by Dmytro on 26.11.2015.
 */
public class AbonentManager {
    public static String wait = "30000";

    public static int getRecordsCount(Selenium selenium) {
        selenium.waitForPageToLoad(wait);
        return selenium.getXpathCount("//input[@type='checkbox']").intValue();
    }

    static void clickHome(Selenium selenium) {
        selenium.open("/");
        selenium.click("link=home");
        selenium.waitForPageToLoad("30000");
    }
}
