Feature: Coding challenges

  Scenario Outline: Print Credit Card Masking
    Then I expect maskify(<str>) returns <result>
    Examples:
      | str           | result        |
      | ""            | ""            |
      | "1"           | "1"           |
      | "1234"        | "1234"        |
      | "12345"       | "*2345"       |
      | "64607935616" | "*******5616" |

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

  Scenario Outline: Reverses string
    When I run reversesStr(str) with <str>
    Then I see <str> reverses to <reversStr>
    Examples:
      | str      | reversStr |
      | "string" | "gnirts"  |
      | "s"      | "s"       |

  Scenario Outline: Returns true if a palindrome
    Then I expect isStrPalindrome(str) returns true for <word>
    Examples:
      | word   |
      | ""     |
      | "a"    |
      | "aa"   |
      | "aba"  |
      | "abba" |

  Scenario Outline: Returns false if not a palindrome
    Then I expect isStrPalindrome(str) returns false for <word>
    Examples:
      | word  |
      | "ab"  |
      | "abs" |

  Scenario: Returns every third element
    Then I expect getThirdElem(str) returns every third element from str

 # TODO undone
  Scenario: Returns two max numbers in the array
    Then  I expect getTwoMaxNums(arr) returns two max numbers from "1,2,3,4"

#    * function	that swaps two array elements
#    * function that accepts integer number and returns
#    * function to find the largest element in an array
#    * function, accepts integer argument It should print all the numbers up to the argument
#    * function that reverses words in a sentence