Feature: Launch all browsers

  @parallel
  Scenario Outline: Test Browsers <Browser>
    Given I initiate "<Browser>" browser
    Examples:
      | Browser |
      | chrome  |
      #| firefox |
      #| ie      |


