package com.pageobect.demo.skyscanner.pages;

import com.pageobect.demo.Utilities.Driver;
import com.pageobect.demo.Utilities.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.pageobect.demo.Utilities.Driver.getActiveDriver;
import static com.pageobect.demo.Utilities.Driver.waitForVisibility;

public class SearchFlightPage extends PageObject {

    @FindBy(id = "fsc-trip-type-selector-one-way")
    private WebElement oneWayRadioBtn;

    @FindBy(id = "fsc-trip-type-selector-return")
    private WebElement returnRadioBtn;

    @FindBy(id = "origin-fsc-search")
    private WebElement fromLocation;

    @FindBy(id = "destination-fsc-search")
    private WebElement toLocation;

    @FindBy(id = "depart-fsc-datepicker-button")
    private WebElement departDatePicker;

    @FindBy(name = "class-travellers-trigger")
    private WebElement travellersSelector;

    @FindBy(xpath = "//button[@aria-label='Search flights']")
    private WebElement searchFlightsBtn;


    public SearchFlightPage(WebDriver driver) {
        super(driver);
    }

    public SearchFlightPage iSelectTripType(final String tripType){
        if("oneway".equals(tripType.toLowerCase())){
            oneWayRadioBtn.click();
        }
        return this;
    }

    public SearchFlightPage iSelectFromLocation(final String fromLocation) {
        waitForVisibility(this.fromLocation);
        this.fromLocation.click();
        this.fromLocation.sendKeys(fromLocation);
        return this;
    }

    public SearchFlightPage iSelectToLocation(final String toLocation) {
        waitForVisibility(this.toLocation);
        this.toLocation.click();
        this.toLocation.sendKeys(toLocation);
        return this;
    }

    public SearchFlightPage iSelectDepartureDate(final String departDate) throws Exception {
        departDatePicker.click();
        final String[] dateArray = departDate.split(",");

        if (dateArray.length < 2) {
            System.out.println("Date of Departure is in Invalid Format, should be DD, MONTH YYYY");
            throw new Exception("Date of Departure is in Invalid Format, should be DD, MONTH YYYY");
        }

        final WebElement monthsElement = getActiveDriver().findElement(By.name("months"));
        Reusable.selectByVisibleText(monthsElement, dateArray[1].trim());

        final String dateLabel = departDate.replace(",", "");
        final String dateXpath = "//table[contains(@class,'bpk-calendar-grid')]//button[contains(@aria-label,'" + dateLabel + "')]";

        getActiveDriver().findElement(By.xpath(dateXpath)).click();
        return this;
    }

    public SearchFlightPage iSelectTravellersInfo(final String cabinClass, final Integer adultCount, final Integer childrenCount) {
        travellersSelector.click();

        final WebElement cabinClassElement = getActiveDriver().findElement(By.name("search-controls-cabin-class-dropdown"));
        Reusable.selectByVisibleText(cabinClassElement, cabinClass);

        if (adultCount > 1) {
            WebElement increaseAdultElement = getActiveDriver().findElement(By.xpath("//button[@title='Increase number of adults']"));
            int defaultCnt = 1;
            while (defaultCnt != adultCount) {
                increaseAdultElement.click();
                defaultCnt++;
            }
        }

        if (childrenCount > 0) {
            WebElement increaseChildElement = getActiveDriver().findElement(By.xpath("//button[@title='Increase number of children']"));
            int defaultCnt = 0;
            while (defaultCnt != childrenCount) {
                increaseChildElement.click();
                defaultCnt++;
            }
        }

        WebElement doneElement = getActiveDriver().findElement(By.xpath("//section[@id='cabin-class-travellers-popover']/footer/button"));
        doneElement.click();
        return this;
    }

    public SelectFlightPage iSearchFlights(){
        searchFlightsBtn.click();
        return new SelectFlightPage(getActiveDriver());
    }


}
