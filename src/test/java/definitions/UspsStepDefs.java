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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

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
            String fullZip = element.getText();
            String shortZip = fullZip.substring(0, 5);
            resultTexts.add(shortZip);
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
        String canadaElem = "//*[@id='CountryID']/option[text()='Canada']";
        WebElement postcardButton = driver.findElement(By.xpath("//*[@id='options-section']//input[@value='Postcard']"));

        countryDropdown.click();
        waitFor(canadaElem).click();
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

    private WebElement waitFor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}


//class QuickToolsMenu {
//    private final WebElement root;
//    private final By zipCodeButtonSelector = By.xpath("//*[@id ='navquicktools']/../..//*[contains(text(), 'ZIP')]");
//
//    public QuickToolsMenu(WebElement root) {
//        this.root = root;
//    }
//
//    public void clickZipCodeButton() {
//        WebElement zipCodeButton = root.findElement(zipCodeButtonSelector);
//        new Actions((WebDriver) zipCodeButton)
//                .moveToElement(zipCodeButton)
//                .click(zipCodeButton)
//                .perform();
//    }
//}
//
//class MainMenu {
//    private final WebElement root;
//    private final By quicktoolsMenuSelector = By.xpath(".//*[@id ='navquicktools']/..");
//
//    public MainMenu(WebElement root) {
//        this.root = root;
//    }
//
//    public QuickToolsMenu openQuickToolsMenu() {
//        WebElement quickToolsMenu = root.findElement(quicktoolsMenuSelector);
//        new Actions((WebDriver) quickToolsMenu)
//                .moveToElement(quickToolsMenu)
//                .perform();
//        return new QuickToolsMenu(quickToolsMenu);
//    }
//}
//
//
//        new MainMenu(driver.findElement(By.xpath("//*[@id = 'g-navigation']")))
//                .openQuickToolsMenu()
//                .clickZipCodeButton();