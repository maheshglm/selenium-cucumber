package com.pageobect.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:testout/reports/cucumber.json",
        features = "src/test/resources/features",
        glue = "com/pageobect/demo/glue",
        monochrome = true,
        dryRun = false,
        tags = "@select_flight"
)
public class CucumberRunner extends BaseRunner {

}
