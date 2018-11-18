Feature: Booking flight using Sky Scanner web site

  As a Sky Scanner Existing User ,
  I should be able to select one way fastest flight with 0 stops between Singapore and Hyderabad

  @select_flight
  Scenario Outline: Select flight using Sky Scanner

    Given I initiate "<BrowserType>" browser

    And I open sky scanner web site
    And I login sky scanner with below credentials
      | Existing-username | password |

    When I select trip type as "<TripType>"
    And I select from location as "<FromLocation>"
    And I select to location as "<ToLocation>"
    And I select departure date as "<DepartDate>"
    And I select number of adults as <NoOfAdults>
    And I click Search flights

    #Below step is commented because Sky Scanner website has CAPTCHA restrictions after this step.
    #Selenium cannot see Select Flight page because of CAPTCHA.

    #Then I select fastest flight with 0 stops

    Examples:
      | BrowserType | TripType | FromLocation | ToLocation | DepartDate        | NoOfAdults |
      | chrome      | OneWay   | SIN          | HYD        | 31, January 2019  | 2          |
      | firefox     | OneWay   | SIN          | HYD        | 2, February 2019  | 1          |
