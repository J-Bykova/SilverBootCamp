package definitions;

import codingchallenge.Printer;
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

    @Then("I see reverses string with {string}")
    public void iSeeReversesStringWith(String str) {}
}
