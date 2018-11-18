package com.pageobect.demo.skyscanner.pages;

import com.pageobect.demo.Utilities.Driver;
import com.pageobect.demo.Utilities.Reusable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.pageobect.demo.Utilities.Driver.waitForVisibility;

public class SelectFlightPage extends PageObject {

    @FindBy(id = "sort-select")
    private WebElement sortElement;

    @FindAll(@FindBy(xpath = "//button[contains(@class,'bpk-button CTASection')]"))
    private List<WebElement> selectFlightsBtn;

    public SelectFlightPage(WebDriver driver){
        super(driver);
    }

    public SelectFlightPage iSelectSortBy(final String sortByValue) {
        waitForVisibility(sortElement);
        Reusable.selectByVisibleText(sortElement,sortByValue);
        return this;
    }

    public SelectFlightPage iSelectFastestFlight(){
        waitForVisibility(selectFlightsBtn.get(0));
        selectFlightsBtn.get(0).click();
        return this;
    }

}
