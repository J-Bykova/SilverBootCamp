package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    WebDriver driver = getDriver();
    WebElement buttonSend = driver.findElement(By.xpath("//a[@id='mail-ship-width']"));
    WebElement linkLookUpZIPCode = driver.findElement(By.xpath("//div[@class='benefits--3']//a[contains(text(), 'ZIP')]"));
    WebElement buttonFindByAddress = driver.findElement(By.xpath("//a[contains(text(), 'Find by Address')]"));
    WebElement fieldStreet = driver.findElement(By.xpath("//input[@id='tAddress']"));
    WebElement fieldCity = driver.findElement(By.xpath("//input[@id='tCity']"));
    WebElement dropDownListOfState = driver.findElement(By.xpath("//select[@id='tState']"));
    WebElement stateCa = driver.findElement(By.xpath("//select[@id='tState']/option[contains(text(), 'California')]"));
    WebElement buttonFind = driver.findElement(By.xpath("//a[@id='zip-by-address']"));
    String resultListItemPath = "//*[@class='zipcode-result-address']//strong";
    String resultsContainerPath = "//*[@id='zipByAddressDiv']";
    WebElement linkToCalculatePrice = driver.findElement(By.xpath("//*[@class='repos']//a[text() = 'Calculate a Price']"));


//    @Given("I go to {string} page")
//    public void iGoToPage(String url) {
//        getDriver().get(url);
//    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        buttonSend.click();
        linkLookUpZIPCode.click();
        buttonFindByAddress.click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        fieldStreet.sendKeys(street);
        fieldCity.sendKeys(city);
        dropDownListOfState.click();
        stateCa.click();
        buttonFind.click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) throws InterruptedException {
        WebElement resultsContainer = waitFor(resultsContainerPath);
        List<WebElement> resultElements = resultsContainer.findElements(By.xpath(resultListItemPath));

        List<String> resultTexts = new ArrayList<>();
        for (WebElement element : resultElements) {
            String fullZip = element.getText();
            String shortZip = fullZip.substring(0, 5);
            resultTexts.add(shortZip);
        }
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
    }

    private WebElement waitFor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
