$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Projects/PaloIT/SeleniumDemo/src/test/resources/features/1002_Select_Fastest_Flight.feature");
formatter.feature({
  "line": 1,
  "name": "Booking flight using Sky Scanner web site",
  "description": "\r\nAs a Sky Scanner Existing User ,\r\nI should be able to select one way fastest flight with 0 stops between Singapore and Hyderabad",
  "id": "booking-flight-using-sky-scanner-web-site",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "Select flight using Sky Scanner",
  "description": "",
  "id": "booking-flight-using-sky-scanner-web-site;select-flight-using-sky-scanner",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@select_flight"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I initiate \"\u003cBrowserType\u003e\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I open sky scanner web site",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I login sky scanner with below credentials",
  "rows": [
    {
      "cells": [
        "maheshglm1@gmail.com",
        "s8RNCs58jhv8UWH"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I select trip type as \"\u003cTripType\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I select from location as \"\u003cFromLocation\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I select to location as \"\u003cToLocation\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I select departure date as \"\u003cDepartDate\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select number of adults as \u003cNoOfAdults\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click Search flights",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 22,
      "value": "#Below step is commented because Sky Scanner website has CAPTCHA restrictions after this step."
    },
    {
      "line": 23,
      "value": "#Selenium cannot see Select Flight page because of CAPTCHA."
    },
    {
      "line": 25,
      "value": "#Then I select fastest flight with 0 stops"
    }
  ],
  "line": 27,
  "name": "",
  "description": "",
  "id": "booking-flight-using-sky-scanner-web-site;select-flight-using-sky-scanner;",
  "rows": [
    {
      "cells": [
        "BrowserType",
        "TripType",
        "FromLocation",
        "ToLocation",
        "DepartDate",
        "NoOfAdults"
      ],
      "line": 28,
      "id": "booking-flight-using-sky-scanner-web-site;select-flight-using-sky-scanner;;1"
    },
    {
      "cells": [
        "chrome",
        "OneWay",
        "SIN",
        "HYD",
        "31, January 2019",
        "2"
      ],
      "line": 29,
      "id": "booking-flight-using-sky-scanner-web-site;select-flight-using-sky-scanner;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 29,
  "name": "Select flight using Sky Scanner",
  "description": "",
  "id": "booking-flight-using-sky-scanner-web-site;select-flight-using-sky-scanner;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@select_flight"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I initiate \"chrome\" browser",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I open sky scanner web site",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I login sky scanner with below credentials",
  "rows": [
    {
      "cells": [
        "maheshglm1@gmail.com",
        "s8RNCs58jhv8UWH"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I select trip type as \"OneWay\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I select from location as \"SIN\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I select to location as \"HYD\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I select departure date as \"31, January 2019\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select number of adults as 2",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click Search flights",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 12
    }
  ],
  "location": "StepDef.java:23"
});
formatter.result({
  "duration": 5540575758,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.java:31"
});
formatter.result({
  "duration": 4081467460,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.java:35"
});
formatter.result({
  "duration": 19421974673,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OneWay",
      "offset": 23
    }
  ],
  "location": "StepDef.java:44"
});
formatter.result({
  "duration": 95725079,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SIN",
      "offset": 27
    }
  ],
  "location": "StepDef.java:48"
});
formatter.result({
  "duration": 294945752,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HYD",
      "offset": 25
    }
  ],
  "location": "StepDef.java:52"
});
formatter.result({
  "duration": 245426963,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "31, January 2019",
      "offset": 28
    }
  ],
  "location": "StepDef.java:56"
});
formatter.result({
  "duration": 777001009,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 29
    }
  ],
  "location": "StepDef.java:64"
});
formatter.result({
  "duration": 651266652,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.java:68"
});
formatter.result({
  "duration": 136776760,
  "status": "passed"
});
formatter.after({
  "duration": 965410434,
  "status": "passed"
});
});