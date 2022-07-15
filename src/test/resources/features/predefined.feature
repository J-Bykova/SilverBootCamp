@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I go to "google" page
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I go to "yahoo" page
    Then I should see page title contains "Yahoo"
    Then element with xpath "//label[text()= 'Search query']/../input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//label[text()= 'Search query']/../input[@name='p']"
    Then I click on element with xpath "//label[text()= 'Search query']/../input[@type='submit']"
    Then I wait for element with xpath "//div[contains(@id, 'main')]" to be present
    Then element with xpath "//div[contains(@id, 'main')]" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I go to "bing" page
    Then I should see page title as "Bing"
    Then element with xpath "//form[@id='sb_form']/input[@type='search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//form[@id='sb_form']/input[@type='search']"
    Then I click on element with xpath "//form[@id='sb_form']/label[@for='sb_form_go']"
    Then I wait for element with xpath "//*[@class='pageRecoContainer']/../../.." to be present
    Then element with xpath "//*[@class='pageRecoContainer']/../../.." should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I go to "gibiru" page
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[contains(@class, 'form-control')]" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[contains(@class, 'form-control')]"
    Then I click on element with xpath "//div[@class='input-group-append']/button"
    Then I wait for element with xpath "//div[@id='web-results']//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@id='web-results']//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I go to "duckDuckGo" page
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for swisscows
    Given I go to "swisscows" page
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='input-search']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='page-results']" to be present
    Then element with xpath "//div[@class='page-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@class='search-bar__search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='search-bar__search']"
    Then I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[contains(@class, 'serp__results')]" to be present
    Then element with xpath "//section[contains(@class, 'serp__results')]" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//form[@id='search']/input[@title='Search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//form[@id='search']/input[@title='Search']"
    Then I click on element with xpath "//form[@id='search']/button[@type='submit']"
    Then I wait for element with xpath "//h3[text()='Web results']/.." to be present
    Then element with xpath "//h3[text()='Web results']/.." should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title as "Yandex"
    Then element with xpath "//span[@class='input__box']//input[contains(@class, 'input__control')]" should be present
    When I type "Behavior Driven Development" into element with xpath "//span[@class='input__box']//input[contains(@class, 'input__control')]"
    Then I click on element with xpath "//form[@role='search']//button"
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then element with xpath "//div[@class='content__left']" should contain text "Cucumber"

# ??????
  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "http://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I wait for element with xpath "//div[contains(@class, 'searchResultsBlock')]" to be present
    Then element with xpath "//div[contains(@class, 'searchResultsBlock')]" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//form[@role='search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//form[@role='search']//input[@type='search']"
    Then I click on element with xpath "//form[@role='search']//button[@type='submit']"
    Then I wait for element with xpath "//section[contains(@class, 'mainline')]" to be present
    Then element with xpath "//section[contains(@class, 'mainline')]" should contain text "Cucumber"


  