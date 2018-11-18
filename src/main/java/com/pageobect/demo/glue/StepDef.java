package com.pageobect.demo.glue;

import com.pageobect.demo.Utilities.Driver;
import com.pageobect.demo.Utilities.Reusable;
import com.pageobect.demo.skyscanner.pages.LoginPage;
import com.pageobect.demo.skyscanner.pages.SearchFlightPage;
import com.pageobect.demo.skyscanner.pages.SelectFlightPage;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class StepDef implements En {

    private WebDriver driver;

    private LoginPage loginPage;
    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;

    public StepDef() {
        Given("^I initiate \"([^\"]*)\" browser$", (String browserType) -> {
            driver = Driver.getWebDriver(browserType);

            loginPage = new LoginPage(driver);
            searchFlightPage = new SearchFlightPage(driver);
            selectFlightPage = new SelectFlightPage(driver);
        });

        Given("^I open sky scanner web site$", () -> {
            loginPage.iLaunchSkyScannerWebsite();
        });

        Given("^I login sky scanner with below credentials$", (DataTable credentials) -> {
            List<String> cells = credentials.getGherkinRows().get(0).getCells();
            String username = cells.get(0);
            String password = cells.get(1);
            loginPage.iInvokeLoginScreen()
                    .iSelectEmailLogin()
                    .iLoginWithValidCredentials(username, password);
        });

        When("^I select trip type as \"([^\"]*)\"$", (String tripType) -> {
            searchFlightPage.iSelectTripType(tripType);
        });

        When("^I select from location as \"([^\"]*)\"$", (String fromLocation) -> {
            searchFlightPage.iSelectFromLocation(fromLocation);
        });

        When("^I select to location as \"([^\"]*)\"$", (String toLocation) -> {
            searchFlightPage.iSelectToLocation(toLocation);
        });

        When("^I select departure date as \"([^\"]*)\"$", (String departureDate) -> {
            try {
                searchFlightPage.iSelectDepartureDate(departureDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        When("^I select number of adults as (\\d+)$", (Integer adultCnt) -> {
            searchFlightPage.iSelectTravellersInfo("Economy",adultCnt,0);
        });

        When("^I click Search flights$", () -> {
            searchFlightPage.iSearchFlights();
        });

        Then("^I select fastest flight with 0 stops$", () -> {
            selectFlightPage.iSelectSortBy("Fastest first");
            Reusable.waitSeconds(2L);
            selectFlightPage.iSelectFastestFlight();
        });

        Then("^I pause for (\\d+) seconds$", (Integer timeout) -> {
            Reusable.waitSeconds(Long.valueOf(timeout));
        });
    }
}
