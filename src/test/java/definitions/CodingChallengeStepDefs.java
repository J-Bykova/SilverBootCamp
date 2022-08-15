package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CodingChallengeStepDefs {
    private String result;

    @When("I run printUpTo\\(n) with {int}")
    public void iRunPrintUpToNWith(int n) {
        result = printUpTo(n);
    }

    @Then("it returns {string}")
    public void itReturns(String expected) {
        Assert.assertEquals(expected, result);
    }

    @When("I run printArrayItems\\(arr)")
    public void iRunPrintArrayArr() {
        printArrayItems();
    }

    @When("I run printArrayEvenItems\\(arr)")
    public void iRunPrintArrayEvenItemsArr() {
        printArrayEvenItems();
    }

    @When("I run isArrEmpty\\(array) with {string}")
    public void iRunIsArrEmptyArrayWithArray(String str) {
        String[] array = str.length() == 0
                ? new String[]{}
                : str.split(",");
        isArrEmpty(array);
    }

    @When("I run reversesStr\\(str) with {string}")
    public void iRunReversesStrStrWith(String str) {
        reversesStr(str);
    }

    @Then("I see {string} reverses to {string}")
    public void iSeeReversesTo(String str, String strResult) {
        Assert.assertEquals(strResult, reversesStr(str));
    }

    @Then("I expect isStrPalindrome\\(str) returns true for {string}")
    public void iExpectIsStrPalindromeStrReturnsTrueForWord(String str) {
        Assert.assertTrue(isStrPalindrome(str));
    }

    @Then("I expect isStrPalindrome\\(str) returns false for {string}")
    public void iExpectIsStrPalindromeStrReturnsFalseForWord(String str) {
        Assert.assertFalse(isStrPalindrome(str));
    }

    @Then("I expect maskify\\({string}) returns {string}")
    public void iExpectMaskifyReturns(String str, String result) {
        Assert.assertEquals(maskify(str), result);
    }

    @Then("I expect getThirdElem\\(str) returns every third element from str")
    public void iExpectGetThirdElemStrReturnsEveryThirdElementFromStr() {
        throw new RuntimeException();
    }

    @Then("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num <= 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println(num);
        }
    }

    @Then("I print 7th day of week")
    public void iPrintDayOfWeek() {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String weekDay : weekDays) {
            System.out.println(weekDay);
        }
    }

    @Then("I print all integer array")
    public void iPrintAllIntegerArr() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int num : arr) {
            System.out.println(num);
        }
    }

    @Then("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int j : arr) {
            if (j % 2 == 0) {
                System.out.println(j);
            }
        }
    }

    @Then("I print {int} if array contains it")
    public void iPrintElementIfArrayContainsIt(int elem) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int x : arr) {
            if (x == elem) {
                System.out.println(x);
            }
        }
    }

    @Then("I print {string} if array contains it")
    public void iPrintElementIfArrayContainsIt(String elem) {
        String[] arr = {"a", "b", "c", "d", "e"};
        for (String x : arr) {
            if (x.equals(elem)) {
                System.out.println(x);
            }
        }
    }

    @Then("I expect findsSum\\(arr) to return true if find sum equal to {int}")
    public void iExpectFindsSumArrToReturnTrueIfFindSumEqualToNum(int num) {
        int[] arr = {1, 2, 3, 4, 5, 10};
        Assert.assertTrue(findsSum(arr, num));
    }

    @Then("I expect getInitial\\({string}) return {string}")
    public void iExpectGetInitialFullNameReturnInitials(String name, String expected) {
        String[] words = name.split(" ");
        String[] initials = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String initial = String.valueOf(word.charAt(0));
            initials[i] = initial;
        }
        String result = String.join(".", initials).toUpperCase();

        Assert.assertEquals(result, expected);
    }

    @Then("I expect isSumOddOrEven\\({string}) to return {string}")
    public void iExpectIsSumOddOrEvenArrToReturnResult(String str, String expected) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getSumOfArray(arr));
    }

    @Then("I expect isOddOrEven\\({int}) returns {string} if num is odd or {string} if num is even")
    public void iExpectIsOddOrEvenNumReturnsIfNumIsOddOrIfNumIsEven(int num, String odd, String even) {
        if (num % 2 == 0) {
            System.out.println(num + " is " + even);
        } else {
            System.out.println(num + " is " + odd);
        }
    }

    @And("Return every third element")
    public void returnEveryThirdElement() {
        String str = "string";
        int[] arr = {1, 2, 3, 4, 5};
        List<String> list = new ArrayList<String>();
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");

        printThirdEl(str);
        printThirdEl(arr);
        printThirdEl(list);
    }

    @And("I run buzzFizz\\({int}) function")
    public void iRunBuzzFizzFunction(int target) {
        for (int num = 1; num <= target; num++) {
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (num % 3 == 0) {
                System.out.print("Fizz ");
            } else if (num % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(num + " ");
            }
        }

    }

    @And("I expect getTwoMaxNums\\(arr) returns two max numbers from array")
    public void iExpectGetTwoMaxNumsArrReturnsTwoMaxNumbersFromArray() {
        int[] arr = {1, 7, 3, 9, 5};
        printTwoMax(arr);
    }

    @And("I expect getLargestElem\\(arr) returns the largest element in an array")
    public void iExpectGetLargestElemArrReturnsTheLargestElementInAnArray() {
        int[] arr = {1, 7, 3, 9, 5};
        printMaxNum(arr);
    }

    private void printMaxNum(int[] arr) {
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
            }
        }
        System.out.println("Max num is " + maxNum);
    }

    private void printTwoMax(int[] arr) {
        int firstNum = Integer.MIN_VALUE;
        int secondNum = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (firstNum < arr[i]) {
                secondNum = firstNum;
                firstNum = arr[i];
            } else if (secondNum < arr[i]){
                secondNum = arr[i];
            }
        }
        System.out.println("First max number is " + firstNum);
        System.out.println("Second max number is " + secondNum);
    }

    private void printThirdEl(String str) {
        for (int i = 0; i < str.length(); i = i + 3) {
            if (i % 3 == 0) {
                System.out.println(str.charAt(i));
            }
        }
    }

    private void printThirdEl(int[] arr) {
        for (int i = 0; i < arr.length; i = i + 3) {
            System.out.println(arr[i]);
        }
    }

    private void printThirdEl(List<String> list) {
        for (int i = 0; i < list.size(); i = i + 3) {
            System.out.println(list.get(i));
        }
    }

    private int getSumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private boolean findsSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    private String maskify(String str) {
        String result = "";
        if (str.length() <= 4) {
            return str;
        } else {
            for (int i = 0; i < str.length() - 4; i++) {
                result += "*";
            }
            return (result + str.substring(str.length() - 4));
        }
    }

    private String printUpTo(int n) {
        List<String> res = new ArrayList<>();
        res.add("0");

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res.add(String.valueOf(i));
            }
        }

        if (n < 0) {
            for (int i = -1; i >= n; i--) {
                res.add(String.valueOf(i));
            }
        }

        return String.join(",", res);
    }

    private void printArrayItems() {
        int[] arr = {1, 2, 3};
        for (int j : arr) {
            System.out.println(j);
        }
        System.out.println("Something wrong");
    }

    private void printArrayEvenItems() {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Something wrong");
    }

    private void isArrEmpty(String[] arr) {
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println("Array is NOT empty");
                System.out.println("Array is " + arr[i]);
            } else
                System.out.println("Array is EMPTY");
        }
    }

    private String reversesStr(String str) {
        if (str.length() == 1) {
            return str;
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }

    private Boolean isStrPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }

        for (int l = 0, r = str.length() - 1; l <= r; l++, r--) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
