package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getDriver;

public class UspsStepDefs {
    String buttonSend = "//a[@id='mail-ship-width']";
    String linkLookUpZIPCode = "//div[@class='benefits--3']//a[contains(text(), 'ZIP')]";
    String buttonFindByAddress = "//a[contains(text(), 'Find by Address')]";
    String fieldStreet = "//input[@id='tAddress']";
    String fieldCity = "//input[@id='tCity']";
    String dropDownListOfState = "//select[@id='tState']";
    String stateCa = "//select[@id='tState']/option[contains(text(), 'California')]";
    String buttonFind = "//a[@id='zip-by-address']";
    String resultListItemPath = "//*[@class='zipcode-result-address']//strong";
    String resultsContainerPath = "//*[@id='zipByAddressDiv']";
    WebDriver driver = getDriver();

    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        getDriver().get(url);
    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        driver.findElement(By.xpath(buttonSend)).click();
        driver.findElement(By.xpath(linkLookUpZIPCode)).click();
        driver.findElement(By.xpath(buttonFindByAddress)).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        driver.findElement(By.xpath(fieldStreet)).sendKeys(street);
        driver.findElement(By.xpath(fieldCity)).sendKeys(city);
        driver.findElement(By.xpath(dropDownListOfState)).click();
        driver.findElement(By.xpath(stateCa)).click();
        driver.findElement(By.xpath(buttonFind)).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) throws InterruptedException {
        WebElement resultsContainer = waitFor(resultsContainerPath);
        List<WebElement> resultElements = resultsContainer.findElements(By.xpath(resultListItemPath));

        List<String> resultTexts = new ArrayList<>();
        for (WebElement element:resultElements) {
            String fullZip = element.getText();
            String shortZip = fullZip.substring(0, 5);
            resultTexts.add(shortZip);
        }
    }

    private WebElement waitFor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
