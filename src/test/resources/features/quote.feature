Feature: Validate Quote

  Background: Open quote page
#    Given I go to "quote" page

  @quote3
  Scenario Outline: Quote page - e2e
    When I fill out required fields for "<role>" user
    Then I verify that fields values saved correctly for "<role>" user
    Examples:
      | role    |
      | regular |
      | admin   |

  #TODO -
  @quote4
  Scenario Outline: Quote page - OOP
    Given I go to "quote" page - OOP
    When I fill out required fields for "<role>" user - OOP
    Then I verify that fields values saved correctly for "<role>" user - OOP
    Examples:
      | role    |
      | regular |
#      | admin   |

#TODO -
  Scenario: Navigation exercises
    And I go to "google" page
    And I go back and forward, then refresh the page

#TODO -
  Scenario: Switch devise exercises
    And I change resolution to "phone"
    And I change resolution to "desktop"

 #TODO -
  Scenario: Verify that chosen date is formed out correctly
    When I click on element with xpath "//input[@id ='dateOfBirth']"
    And I click on element with xpath "//td[contains(@class, 'ui-datepicker-current-day')]"
    Then element with xpath {string} should have text as {string}

  Scenario: Get info from page exercises
    When I print current page URL
    And I print page title
    * I print window handles
    * I print page source

  Scenario: Quote page - alert, iframe, new window
    When I "accept" third party agreement
    And I fill out contact name "Silvestr" and phone "0987654321"
    Then I verify "Document 2" in related documents

  Scenario: Verify that upon clicking dialog appears
    When I click on element with xpath "//input[@id ='dateOfBirth']"
    Then element with xpath "//div[@id ='ui-datepicker-div']" should be displayed

  Scenario Outline: Validate responsive UI for Quote
    When I resize window to <width> and <height>
    Then element with xpath "//div[@class='title']/../div[@class='row']" should be displayed
    Examples:
      | width | height |
      | 800   | 1024   |
      | 1280  | 1024   |

  Scenario Outline: Validate responsive UI for Quote for mobile
    When I resize window to <width> and <height>
    Then element with xpath "//*[@id='location']" should not be displayed
    * element with xpath "//*[@id='currentDate']" should not be displayed
    * element with xpath "//*[@id='currentTime']" should not be displayed
    Examples:
      | width | height |
      | 400   | 1024   |

  Scenario: Validate required fields
    When I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    * element with xpath "//label[@id='email-error']" should be displayed
    * element with xpath "//label[@id='password-error']" should be displayed
    * element with xpath "//label[@id='name-error']" should be displayed
    * element with xpath "//label[@for='agreedToPrivacyPolicy']" should be displayed

  Scenario: Require length of username field
    When I type "J" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    But I type "enny" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not contain text "Please enter at least 2 characters."

  Scenario Outline: Require length of password field
    When I type "<invalid_password>" into element with xpath "//input[@name='password']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[text()='Please enter at least 5 characters.']" should be displayed
    But I type "<valid_password>" into element with xpath "//input[@name='password']"
    Then element with xpath "//label[@id='password-error']" should not contain text "Please enter at least 5 characters."
    Examples:
      | invalid_password | valid_password |
      | 1                | 12345          |
      | 1234             | 123456         |

  Scenario: Validate of Confirm Password field
    And element with xpath "//input[@name='confirmPassword']" should be disabled
    When  I type "password" into element with xpath "//input[@name='password']"
    Then element with xpath "//input[@name='confirmPassword']" should be enabled

  Scenario Outline: Validate of invalid email field
    When I type "<invalid_email>" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[text()='Please enter a valid email address.']" should be displayed
    Examples:
      | invalid_email             |
      | s                         |
      | #@%^%#$@#$@#.com          |
      | @example.com              |
      | <email@example.com>       |
      | email.example.com         |
      | email@example@example.com |
      | .email@example.com        |
      | email@111.222.333.44444   |
      | email@example..com        |


  Scenario Outline: Validate name field behavior with save data
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']/.." should be displayed
    When I type "<name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='firstName']"
    * I type "<middle_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='middleName']"
    * I type "<last_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='lastName']"
    And I click on element with xpath "//div[@id='nameDialog']/..//span[contains(text(),'Save')]/.."
    Then element with xpath "//input[@id='name']" should have attribute "value" as "<full_name>"
    Examples:
      | name  | middle_name | last_name | full_name      |
      | Jenny |             |           | Jenny          |
      | Jenny |             | Bykova    | Jenny Bykova   |
      | Jenny | S           | Bykova    | Jenny S Bykova |
      | Jenny | S           |           | Jenny S        |
      |       |             | Bykova    | Bykova         |
      |       | S           |           | S              |

  Scenario Outline: Validate name field behavior without save data
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']/.." should be displayed
    When I type "<name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='firstName']"
    * I type "<middle_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='middleName']"
    * I type "<last_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='lastName']"
    And I click on element with xpath "<type_of_button>"
    Then element with xpath "//input[@id='name']" should not have attribute "value" as "<full_name>"
    Examples:
      | name  | middle_name | last_name | full_name      | type_of_button                                                 |
      | Jenny | S           | Bykova    | Jenny S Bykova | //div[@id='nameDialog']/..//span[contains(text(),'Cancel')]/.. |
      | Jenny | S           | Bykova    | Jenny S Bykova | //div[@id='nameDialog']/..//span[contains(text(),'Close')]/..  |

  Scenario Outline: Submit the form and verify the data
    When I click on element with xpath "//input[@id='name']"
    * I type "<first_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='firstName']"
    * I type "<last_name>" into element with xpath "//div[@id='nameDialog']/..//input[@id='lastName']"
    * I click on element with xpath "//div[@id='nameDialog']/..//span[contains(text(),'Save')]/.."
    * I type "<user_name>" into element with xpath "//input[@name='username']"
    * I type "<email>" into element with xpath "//input[@name='email']"
    * I type "<password>" into element with xpath "//input[@name='password']"
    * I type "<password>" into element with xpath "//input[@name='confirmPassword']"
    * I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    * I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//*[@class='applicationResult']" should be present
    * element with xpath "//*[@class='applicationResult']/..//*[@name='username']" should have text as "<user_name>"
    * element with xpath "//*[@class='applicationResult']/..//*[@name='firstName']" should have text as "<first_name>"
    * element with xpath "//*[@class='applicationResult']/..//*[@name='email']" should have text as "<email>"
    * element with xpath "//*[@class='applicationResult']/..//*[@name='lastName']" should have text as "<last_name>"
    * element with xpath "//*[@class='applicationResult']/..//*[@name='name']" should have text as "<full_name>"
    Examples:
      | first_name | last_name | user_name | email       | password | full_name    |
      | Jenny      | Bykova    | Jenny_B   | j@gmail.com | 12345    | Jenny Bykova |
