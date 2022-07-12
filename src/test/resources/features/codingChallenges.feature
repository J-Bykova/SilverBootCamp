Feature: Coding challenges

  Scenario Outline: prints all numbers from 0 up to n
    When I run printUpTo(n) with <n>
    Then it returns <result>
    Examples:
      | n  | result        |
      | -1 | "0,-1"        |
      | 0  | "0"           |
      | 1  | "0,1"         |
      | 5  | "0,1,2,3,4,5" |

  Scenario: prints all integer array
    When I run printArrayItems(arr)
#    Then it returns <result>

  Scenario: prints all even numbers from integer array
    When I run printArrayEvenItems(arr)

  Scenario Outline: Returns false when not empty
    When I run isArrEmpty(array) with <array>
    Examples:
      | array |
      | ""    |
      | "1"   |
      | "1,2" |

  Scenario: Checks if array contains element
    When I run isArrContainsElem(arr)


#    * function	that swaps two array elements
#    * function that accepts integer number and returns
#    * function to find the largest element in an array
#    * function, accepts integer argument It should print all the numbers up to the argument
#    * function that reverses string
#    * function that reverses words in a sentence