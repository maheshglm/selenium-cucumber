package com.pageobect.demo.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static AtomicInteger screenshotCounter = new AtomicInteger(1);

    public static WebDriver getWebDriver(final String browser){
        if(browser.equals(BrowserType.CHROME.name().toLowerCase())){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX.name().toLowerCase())){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equals(BrowserType.IE.name().toLowerCase())){
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void takeScreenshot(final String filepath) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filepath);
        FileUtils.copyFile(screenshotAs,destFile);
    }

    public static void quitWebDriver() {
        String name = driver.getClass().getName();
        if(driver.getClass().getName().endsWith("InternetExplorerDriver")){
            try {
                Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            driver.quit();
        }
    }

    public static void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void launchURL(final String url){
        driver.get(url);
    }

    public static WebDriver getActiveDriver(){
        return driver;
    }

}
