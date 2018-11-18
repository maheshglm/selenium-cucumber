package com.pageobect.demo.glue;

import com.pageobect.demo.Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

public class Hooks {

    @After
    public void teardown(Scenario scenario) {
        if(scenario.isFailed()){
            try {
                String filepath = "testout/screenshots/OnFailure.png";
                Driver.takeScreenshot(filepath);
                scenario.embed(filepath.getBytes(),"image/png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Driver.quitWebDriver();
    }

}
