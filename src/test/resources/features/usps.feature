Feature: USPS

  Background: Open usps page
    Given I go to "usps" page

  Scenario Outline: Validate ZIP code by address
    When I go to Lookup ZIP page by address
    And I fill out <street> street, <city> city, <state> state
    Then I validate <zip> zip code exists in the result
    Examples:
      | street                | city        | state | zip     |
      | "4970 El Camino Real" | "Los Altos" | "CA"  | "94022" |
      | "20 Broad st"         | "New York"  | "NY"  | "10005" |
      | "440 S. LaSalle st"   | "Chicago"   | "IL"  | "60605" |
#TODO
  Scenario Outline: Calculate price
    When I go to Calculate Price Page
    And I select <country> with Postcard shape
    And I define <quantity> quantity
    Then I calculate the price and validate cost is <price>
    Examples:
      | country  | quantity | price   |
      | "Canada" | "2"      | "$2.80" |
#      | "Aruba"  | "3"      | "$4.20" |
#TODO
  Scenario: Verify location
    When I perform Free Boxes search
    And I set 'Send' in filters
    Then I verify that 7 results found
    When I select 'Priority Mail | USPS' in result
    And I click 'Ship Now' button
    Then I validate that Sign In is required
#TODO
  Scenario: Every door direct mail
    When I go to 'Every Door Direct Mail' under 'Business'
    And I search for '4970 El Camino Real, Los Altos, CA 94022'
    And I choose view as 'Table' on the map
    And I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

#TODO - HOMEWORK FOR DAY 13
#  Scenario: E2E UPS Scenario
#    When I go to Create a Shipment
#    And I fill out origin shipment fields
#    * I submit the shipment form
#    Then I verify origin shipment fields submitted
