package com.pageobect.demo.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reusable {

    public static void selectValue(final WebElement webElement, final String value) {
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public static void selectByVisibleText(final WebElement webElement, final String visibleText){
        Select select = new Select(webElement);
        select.selectByVisibleText(visibleText);
    }

    public static void waitSeconds(final Long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitMillis(final Long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
