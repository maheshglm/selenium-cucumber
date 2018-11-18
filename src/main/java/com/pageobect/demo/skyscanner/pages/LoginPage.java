package com.pageobect.demo.skyscanner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pageobect.demo.Utilities.Driver.*;
import static com.pageobect.demo.Utilities.Reusable.waitSeconds;

public class LoginPage extends PageObject {

    private static final String URL = "https://www.skyscanner.com.sg/";

    @FindBy(xpath = "//li[contains(@id,'login-button')]/button")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'emailLogoContainer')][@role='button']")
    private WebElement emailLogin;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[contains(@class,'Login__submit')]//button[@type='submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage iLaunchSkyScannerWebsite() {
        launchURL(URL);
        return this;
    }

    public LoginPage iInvokeLoginScreen() {
        waitForVisibility(loginBtn);
        loginBtn.click();
        return this;
    }

    public LoginPage iSelectEmailLogin() {
        waitSeconds(2L);
        if (emailLogin.isDisplayed()) {
            emailLogin.click();
        }
        return this;
    }

    public SearchFlightPage iLoginWithValidCredentials(final String email, final String password) {
        waitForVisibility(emailInput);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.submit();
        waitSeconds(1L);
        new WebDriverWait(getActiveDriver(), 60)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-modal")));
        return new SearchFlightPage(getActiveDriver());
    }


}
