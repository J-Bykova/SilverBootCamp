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