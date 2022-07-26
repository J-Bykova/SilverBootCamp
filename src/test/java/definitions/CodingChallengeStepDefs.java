package definitions;

import codingchallenge.Printer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        new Printer().getTwoMaxNums(convertToArr(str));
    }

    @Then("I expect maskify\\({string}) returns {string}")
    public void iExpectMaskifyReturns(String str, String result) {
        Assert.assertEquals(maskify(str), result);
    }

    @Then("I expect getThirdElem\\(str) returns every third element from str")
    public void iExpectGetThirdElemStrReturnsEveryThirdElementFromStr() {
        throw new RuntimeException();
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

    private char[] convertToArr(String str) {
        return str.toCharArray();
    }
}
