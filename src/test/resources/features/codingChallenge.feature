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

  Scenario Outline: example of java conditions
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
      | 10  | "jenny sergey bykova" | "J.S.B"  |

#  HOMEWORK FOR DAY 7
#  2) Given array: {5,2,9,7,3}
#  Write a function that swaps two array elements – 3rd and 5th
#  3) Write a function that accepts integer number and prints
#  "divisible by 3" if number is divisible by 3 "divisible by 4" if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4
#  4) Write a function to find the largest element in an array
#  5) Write a function, accepts integer argument
#  It should print all the numbers up to the argument
#  BUT:
#  if number is multiple of 3, it should print Fizz instead of number
#  if number is multiple of 5, it should print Buzz instead of number
#  if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
#  Result for 20:
#  1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
#  7) Write a function that reverses words in a sentence


#  HOMEWORK FOR DAY 9
#  b) Write a function that finds 2 max numbers in the array


#  HOMEWORK FOR DAY 11
#  b) Vowels
#  Return the number (count) of vowels in the given string.
#  We will consider a, e, i, o, u as vowels for this Kata (but not y).
#  The input string will only consist of lower case letters and/or spaces.
