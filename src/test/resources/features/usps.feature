Feature: USPS
  Scenario Outline: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out <street> street, <city> city, <state> state
    Then I validate <zip> zip code exists in the result
    Examples:
      | street                | city        | state | zip     |
      | "4970 El Camino Real" | "Los Altos" | "CA"  | "94022" |

  Scenario Outline: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select <country> with Postcard shape
    And I define <quantity> quantity
    Then I calculate the price and validate cost is <price>
    Examples:
      | country  | quantity | price   |
      | "Canada" | "2"      | "$2.80" |
#      | "Aruba"  | "3"      | "$4.20" |

#  HOMEWORK FOR DAY 10
  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required
#  For the last scenario last step you can use the following snippet to switch to a new tab. We'll review it in the next class:
#  // switch to new window
#  for (String handle : getDriver().getWindowHandles()) {
#  getDriver().switchTo().window(handle);
#  }

#  HOMEWORK FOR DAY 11
  Scenario: Every door direct mail
    Given I open "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

#  HOMEWORK FOR DAY 12
  Scenario: Every door direct mail
    Given I open "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary