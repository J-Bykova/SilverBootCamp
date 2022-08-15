package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.channel.unix.Errors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    WebDriver driver = getDriver();

    @When("I print current page URL")
    public void printCurrentPageURL() {
        System.out.println(driver.getCurrentUrl());
    }

    @And("I print page title")
    public void printPageTitle() {
        System.out.println(driver.getTitle());
    }

    @And("I print window handles")
    public void printWindowHandles() {
        System.out.println(driver.getWindowHandle());
    }

    @And("I print page source")
    public void printPageSource() {
        System.out.println(driver.getPageSource());
    }

    @When("I {string} third party agreement")
    public void iAcceptThirdPartyAgreement(String action) {
        driver.findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        switch (action) {
            case "accept" -> getDriver().switchTo().alert().accept();
            case "decline" -> getDriver().switchTo().alert().dismiss();
            default -> throw new Error("Incorrect action: " + action);
        }

    }

    @And("I fill out contact name {string} and phone {string}")
    public void iFillOutContactNameAndPhone(String name, String phone) {
        getDriver().switchTo().frame("additionalInfo");
        driver.findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);
        getDriver().switchTo().defaultContent();
    }

    @Then("I verify {string} in related documents")
    public void iVerifyInRelatedDocuments(String doc) {
        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();

        for (String handle : driver.getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        String docText = driver.findElement(By.xpath("//body")).getText();

        assertThat(docText).contains(doc);

        driver.switchTo().window(originalWindow);
    }
}
