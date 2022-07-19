package definitions;

import codingchallenge.Printer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class CodingChallengeStepDefs {
    private String result;

    @When("I run printUpTo\\(n) with {int}")
    public void iRunPrintUpToNWith(int n) {
        result = new Printer().printUpTo(n);
    }

    @Then("it returns {string}")
    public void itReturns(String expected) {
        Assert.assertEquals(expected, result);
    }

    @When("I run printArrayItems\\(arr)")
    public void iRunPrintArrayArr() {
        new Printer().printArrayItems();
    }

    @When("I run printArrayEvenItems\\(arr)")
    public void iRunPrintArrayEvenItemsArr() {
        new Printer().printArrayEvenItems();
    }

    @When("I run isArrEmpty\\(array) with {string}")
    public void iRunIsArrEmptyArrayWithArray(String str) {
        String[] array = str.length() == 0
                ? new String[]{}
                : str.split(",");
        new Printer().isArrEmpty(array);
    }

    @When("I run isArrContainsElem\\(arr)")
    public void iRunIsArrContainsElemArr() {
        new Printer().isArrContainsElem();
    }

    @When("I run reversesStr\\(str) with {string}")
    public void iRunReversesStrStrWith(String str) {
        new Printer().reversesStr(str);
    }

    @Then("I see {string} reverses to {string}")
    public void iSeeReversesTo(String str, String strResult) {
        Assert.assertEquals(strResult, new Printer().reversesStr(str));
    }

    @Then("I expect isStrPalindrome\\(str) returns true for {string}")
    public void iExpectIsStrPalindromeStrReturnsTrueForWord(String str) {
        Assert.assertTrue(new Printer().isStrPalindrome(str));
    }

    @Then("I expect isStrPalindrome\\(str) returns false for {string}")
    public void iExpectIsStrPalindromeStrReturnsFalseForWord(String str) {
        Assert.assertFalse(new Printer().isStrPalindrome(str));
    }

    @Then("I expect getTwoMaxNums\\(arr) returns two max numbers from {string}")
    public void iExpectGetTwoMaxNumsArrReturnsTwoMaxNumbersFrom(String str) {
        String[] numArray = null;
        numArray = str.split(" ");
        for (int i = 0; i< numArray.length; i++){
            System.out.println(numArray[i]);
        }
        throw new RuntimeException();
    }
}
