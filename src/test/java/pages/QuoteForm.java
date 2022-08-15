package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteForm {
    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//div[@id='nameDialog']/..//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//div[@id='nameDialog']/..//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//div[@id='nameDialog']/..//span[contains(text(),'Save')]/..")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicyCheckbox;
    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement formSubmitButton;
}
