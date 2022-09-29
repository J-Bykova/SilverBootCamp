package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import static org.assertj.core.api.AssertionsForClassTypes.within;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    WebDriver driver = getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement navMenuSendButton = driver.findElement(By.xpath("//*[@id='navmailship']/../a[text()='Send']"));

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        String findZipCodeLink = "//*[@class='container-fluid']//a[contains(text(), 'Look Up a ZIP Code')]";
        String findByAddressLink = "//*[@id='zip-lookup-welcome']//a[text()= 'Find by Address']";

        navMenuSendButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(findZipCodeLink))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(findByAddressLink))).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        String streetAddressField = "//input[@id='tAddress']";
        String cityField = "//input[@id='tCity']";
        String statesDropdown = "//select[@id='tState']";
        String zipCodeFindButton = "//a[@id='zip-by-address']";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(streetAddressField))).sendKeys(street);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityField))).sendKeys(city);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(statesDropdown))).click();

        Select stateSelect = new Select(driver.findElement(By.xpath(statesDropdown)));
        stateSelect.selectByValue(state);

        driver.findElement(By.xpath(zipCodeFindButton)).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
        String resultListItemPath = "//*[@class='zipcode-result-address']//strong";
        String resultsContainerPath = "//*[@id='zipByAddressDiv']";

        WebElement resultsContainer = waitForVisible(resultsContainerPath);
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
//        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='CountryID']"));
//        WebElement countryElem = driver.findElement(By.xpath(String.format("//option[text()='%s']", country)));
        WebElement postcardButton = driver.findElement(By.xpath("//*[@id='options-section']//input[@value='Postcard']"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='CountryID']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(String.format("//option[text()='%s']", country))))).click();
        postcardButton.click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
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
    public void iPerformSearch() {
        //TODO rewrite using typing info into field: type into field and click enter
        WebElement searchIcon = driver.findElement(By.xpath("//li[contains(@class, 'nav-search')]//a[text()='Search USPS.com']"));
        WebElement searchFreeBoxes = driver.findElement(By.xpath("//li[contains(@class, 'nav-search')]//*[text()='FREE BOXES']"));

        actions.moveToElement(searchIcon).perform();
        actions.moveByOffset(0, 50).perform();
        actions.moveToElement(searchFreeBoxes).click().perform();
        waitForSpinner();
    }

    @And("I set {string} in filters")
    public void iSetFilters(String nameOfFilter) {
        WebElement filter = driver.findElement(By.xpath(String.format("//label[contains(text(), '%s')]", nameOfFilter)));
        filter.click();
        waitForSpinner();
    }

    @When("I go to {string} under {string}")
    public void iGoToPage(String subMenu, String menu) {
        WebElement navMenu = driver.findElement(By.xpath(String.format("//nav//a[text()='%s']", menu)));
        WebElement navSubMenu = driver.findElement(By.xpath(String.format("//*[text()='Tools']/..//a[text()='%s']", subMenu)));

        actions.moveToElement(navMenu).moveByOffset(0, 50).moveToElement(navSubMenu).click().perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        WebElement fieldOfSearchForRoutes = waitForPresent("//label[text()='Search for Routes']/..//input[@id='cityOrZipCode']");
        WebElement searchButton = waitForPresent("//a[contains(@class,'eddm-search-btn') and text()='Search']");

        actions.moveToElement(fieldOfSearchForRoutes)
                .click()
                .sendKeys(address)
                .perform();

        actions.moveToElement(searchButton)
                .click()
                .perform();

        waitForSpinner();
    }

    @Then("I verify that {int} results found")
    public void iVerifyThatResults(Integer count) {
        String resultHeader = driver.findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(resultHeader).contains(count.toString());

        List<WebElement> result = driver.findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(result.size()).isEqualTo(count);
    }

    @When("I select {string} in result")
    public void iSelectResult(String title) {
        WebElement result = driver.findElement(By.xpath(String.format("//ul[@id='records']/li//span[text()='%s']", title)));
        result.click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) {
        driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", buttonName))).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        waitForSpinner();

        String title = driver.getTitle();
        assertThat(title).contains("Sign In");

        driver.switchTo().window(originalWindow);
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String typeOfView) {
        driver.findElement(By.xpath(String.format("//ul[contains(@class, 'view-tabs')]//span[text()='%s']/..", typeOfView))).click();
    }

    @And("I select all in the table")
    public void iSelectAllInTheTable() {
        driver.findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        driver.findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        List<WebElement> costCells = driver.findElements(By.xpath("//table[contains(@class,'target-audience-table')]//td[9]/p"));
        WebElement approximateCostElem = driver.findElement(By.xpath("//*[@id='approximateCost']"));
        double displayedCost = Double.parseDouble(approximateCostElem.getText().substring(1));
        double calculatedCost = 0;

        for (WebElement cell : costCells) {
            scrollTo(cell);
            calculatedCost += Double.parseDouble(cell.getText().substring(1));
        }

        assertThat(displayedCost).isEqualTo(calculatedCost, within(0.1));
    }

    private void waitForSpinner() {
        WebElement spinner = driver.findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    private WebElement waitForVisible(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private WebElement waitForPresent(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    private WebElement scrollTo(WebElement elem) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true)", elem);
        if (!elem.isDisplayed()) {
            throw new RuntimeException("Cannot scroll to the element");
        }
        return elem;
    }
}
