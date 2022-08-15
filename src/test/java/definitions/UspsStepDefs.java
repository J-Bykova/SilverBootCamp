package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    WebDriver driver = getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    WebElement navMenuSendButton = driver.findElement(By.xpath("//*[@id='navmailship']/../a[text()='Send']"));

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        String findZipCodeLink = "//*[@class='container-fluid']//a[contains(text(), 'Look Up a ZIP Code')]";
        String findByAddressLink = "//*[@id='zip-lookup-welcome']//a[text()= 'Find by Address']";

        navMenuSendButton.click();
        driver.findElement(By.xpath(findZipCodeLink)).click();
        driver.findElement(By.xpath(findByAddressLink)).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        String streetAddressField = "//input[@id='tAddress']";
        String cityField = "//input[@id='tCity']";
        String statesDropdown = "//select[@id='tState']";
        String zipCodeFindButton = "//a[@id='zip-by-address']";

        driver.findElement(By.xpath(streetAddressField)).sendKeys(street);
        driver.findElement(By.xpath(cityField)).sendKeys(city);
        driver.findElement(By.xpath(statesDropdown)).click();

        Select stateSelect = new Select(driver.findElement(By.xpath(statesDropdown)));
        stateSelect.selectByValue(state);

        driver.findElement(By.xpath(zipCodeFindButton)).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
        String resultListItemPath = "//*[@class='zipcode-result-address']//strong";
        String resultsContainerPath = "//*[@id='zipByAddressDiv']";

        WebElement resultsContainer = waitFor(resultsContainerPath);
        List<WebElement> resultElements = resultsContainer.findElements(By.xpath(resultListItemPath));

        List<String> resultTexts = new ArrayList<>();
        for (WebElement element : resultElements) {
            if (element.isDisplayed()) {
                String fullZip = element.getText();
                String shortZip = fullZip.substring(0, 5);
                resultTexts.add(shortZip);
            }
        }
        assertThat(resultTexts).contains(zipCode);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement calcPriceButton = driver.findElement(By.xpath("//*[@class='tool-calc']/a[text()='Calculate a Price']"));

        actions.moveToElement(navMenuSendButton).moveToElement(calcPriceButton).click(calcPriceButton).perform();
    }

    @And("I select {string} with Postcard shape")
    public void iSelectCountryWithShape(String country) {
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='CountryID']"));
        WebElement countryElem = driver.findElement(By.xpath(String.format("//option[text()='%s']", country)));
        WebElement postcardButton = driver.findElement(By.xpath("//*[@id='options-section']//input[@value='Postcard']"));

        wait.until(ExpectedConditions.presenceOfElementLocated((By) countryDropdown)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By) countryElem)).click();
        postcardButton.click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantityQuantity(String quantity) {
        String quantityInput = "//input[@id='quantity-0']";

        driver.findElement(By.xpath(quantityInput)).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIsPrice(String expectedPrice) throws InterruptedException {
        WebElement calculateButton = driver.findElement(By.xpath("//*[@id='continue-section']/input"));
        WebElement costElem = driver.findElement(By.xpath("//*[@id='cost-0']"));

        calculateButton.click();
        Thread.sleep(5000);

        String actualPrice = costElem.getText();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @When("I perform Free Boxes search")
    public void iPerformFreeBoxesSearch() {
        WebElement searchIcon = driver.findElement(By.xpath("//li[contains(@class, 'nav-search')]//a[text()='Search USPS.com']"));
        WebElement searchFreeBoxes = driver.findElement(By.xpath("//li[contains(@class, 'nav-search')]//*[text()='FREE BOXES']"));

        actions.moveToElement(searchIcon).perform();
        actions.moveByOffset(0, 50).perform();
        actions.moveToElement(searchFreeBoxes).click().perform();
    }

    @And("I set Send in filters")
    public void iSetSendInFilters() {
        WebElement checkboxSend = driver.findElement(By.xpath("//label[text()='Send']/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(checkboxSend)).click();
    }

    @When("I go to Every Door Direct Mail under Business")
    public void iGoToEveryDoorDirectMailUnderBusiness() {
        WebElement navMenuBusinessButton = driver.findElement(By.xpath("//nav//a[text()='Business']"));
        WebElement everyDoorDirectMail = driver.findElement(By.xpath("//*[text()='Tools']/..//a[text()='Every Door Direct Mail']"));

        actions.moveToElement(navMenuBusinessButton).moveToElement(everyDoorDirectMail).click().perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id='cityOrZipCode']"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='geoLocation']/../../../..//a[text()='Search']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated((By) searchField)).sendKeys(address);
    }

    private WebElement waitFor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
