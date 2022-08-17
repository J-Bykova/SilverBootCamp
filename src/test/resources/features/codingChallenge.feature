Feature: Coding challenges

  Scenario: Sorting arrays
    When I expect bubbleSort(arr) to return sorted array
    #    And I expect isSort(arr) to return false if array is unsorted

  Scenario: My coding challenges
    Then I expect isOddOrEven(5) returns "odd" if num is odd or "even" if num is even
    And Return every third element
    And I run buzzFizz(20) function
    And I expect getLargestElem(arr) returns the largest element in an array
    And I expect getTwoMaxNums(arr) returns two max numbers from array
#    Then I expect isPrime(n) to return true if num is
#    And I expect swapsElem(arr, firstNum, secondNum) swaps "3" and "5" elem into "array"
#    And I expect reversesSentence(str) reverses words in a sentence
#    And I expect getAverageOfNum(arr) calculates the average of the numbers in list
##  Note: Empty arrays should return 0. ^
#    And I expect getDuplicates(arr) returns true if find duplicates
#    And I expect getVowelsFromStr(str) returns count vowels in the string
#    And I expect isSumOddOrEven(arr) to return ""
#    And I expect divisibleByNum() return num
#    And I expect getThirdElem(str) returns every third element from str


#  * Determine O() for remaining existing coding challenges

#  * Write a function that accepts integer number and prints
#       "divisible by 3" if number is divisible by 3 "divisible by 4" if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4

  Scenario: prints all integer array
    When I run printArrayItems(arr)

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

  Scenario: Prints all even numbers from integer array
    When I run printArrayEvenItems(arr)

  Scenario Outline: Returns false when not empty
    When I run isArrEmpty(array) with <array>
    Examples:
      | array |
      | ""    |
      | "1"   |
      | "1,2" |

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

  Scenario Outline: Example of java conditions
    * I print if number <num> is positive
    * I print 7th day of week
    * I print all integer array
    * I print all even numbers from integer array
    * I print <element> if array contains it
    Examples:
      | num | element |
      | -1  | 3       |
      | 0   | "c"     |
      | 1   | 1       |
      | 35  | "d"     |

  Scenario Outline: Homework for day 12
    * I expect findsSum(arr) to return true if find sum equal to <num>
    * I expect getInitial(<name>) return <initials>
    Examples:
      | num | name                  | initials |
      | 5   | "Sam Harris"          | "S.H"    |
      | 10  | "patrick feeney"      | "P.F"    |
      | 12  | "jenny sergey bykova" | "J.S.B"  |
