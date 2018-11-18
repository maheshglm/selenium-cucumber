package com.pageobect.demo.parallel;

import org.junit.runner.RunWith;
import com.pageobect.demo.Utilities.Reports;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import com.pageobect.demo.BaseRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"D:/Projects/PaloIT/SeleniumDemo/src/test/resources/features/1002_Select_Fastest_Flight.feature:29"},
        plugin = {"json:D:/Projects/PaloIT/SeleniumDemo/testout/reports/1.json", "html:D:/Projects/PaloIT/SeleniumDemo/testout/reports/1"},
        glue = {"com.pageobect.demo.glue"},
        monochrome = true
)
public class Parallel01IT extends BaseRunner {

}

