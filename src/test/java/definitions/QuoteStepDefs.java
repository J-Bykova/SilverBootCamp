package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.channel.unix.Errors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.TestContext;

import java.io.FileNotFoundException;
import java.util.Map;

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

    @When("I fill out required fields for {string} user")
    public void iFillOutRequiredFieldsForUser(String role) {
        Map<String, String> user = TestContext.getDataByFileName(role);

        driver.findElement(By.xpath("//input[@id='name']")).click();
        driver.findElement(By.xpath("//div[@id='nameDialog']/..//input[@id='firstName']")).sendKeys(user.get("firstName"));
        driver.findElement(By.xpath("//div[@id='nameDialog']/..//input[@id='lastName']")).sendKeys(user.get("lastName"));
        driver.findElement(By.xpath("//div[@id='nameDialog']/..//span[contains(text(),'Save')]/..")).click();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(user.get("password"));
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user.get("password"));

        driver.findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

        driver.findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify that fields values saved correctly for {string} user")
    public void iVerifyThatFieldsValuesSavedCorrectlyForUser(String role) {
        Map<String, String> user = TestContext.getDataByFileName(role);
        String firstNameResult = driver.findElement(By.xpath("//b[@name='firstName']")).getText();
        String lastNameResult = driver.findElement(By.xpath("//b[@name='lastName']")).getText();
        String emailResult = driver.findElement(By.xpath("//b[@name='email']")).getText();
        String usernameResult = driver.findElement(By.xpath("//b[@name='username']")).getText();
        String passwordResult = driver.findElement(By.xpath("//b[@name='password']")).getText();

        assertThat(firstNameResult).contains(user.get("firstName"));
        assertThat(lastNameResult).contains(user.get("lastName"));
        assertThat(emailResult).contains(user.get("email"));
        assertThat(usernameResult).contains(user.get("username"));
        assertThat(passwordResult).doesNotContain(user.get("password"));
    }
}























