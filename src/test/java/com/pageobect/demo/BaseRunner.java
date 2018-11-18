package com.pageobect.demo;

import com.pageobect.demo.Utilities.Reports;
import org.junit.AfterClass;

public class BaseRunner {

    @AfterClass
    public static void generateReports() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Reports reports = new Reports();
            reports.generateReports("testout/reports");
        }));
    }
}
