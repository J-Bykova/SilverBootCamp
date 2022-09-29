package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteForm extends QuotePage {
    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//div[@id='nameDialog']/..//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//div[@id='nameDialog']/..//input[@id='middleName']")
    private WebElement middleName;
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
    private WebElement submitButton;

    public QuoteForm(){
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    public void fillUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillPasswordFields(String password) {
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

    public void fillName(String firstName, String lastName) {
        this.name.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.saveButton.click();
    }

    public void fillName(String firstName, String middleName, String lastName) {
        this.name.click();
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
        this.saveButton.click();
    }

    public void acceptPrivacyPolicy() {
        if (!(privacyPolicyCheckbox.isSelected())) {
            this.privacyPolicyCheckbox.click();
        }
    }

    public void declinePrivacyPolicy() {
        if (privacyPolicyCheckbox.isSelected()) {
            this.privacyPolicyCheckbox.click();
        }
    }

    public void submitForm() {
        this.submitButton.click();
    }
}
