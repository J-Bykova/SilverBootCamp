package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResult extends QuotePage {

    @FindBy(xpath = "//*[@id='quotePageResult']//section")
    private WebElement resultApplication;
    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    public String getApplicationDetails() {
        return resultApplication.getText();
    }

    public String getPasswordText() {
        return password.getText();
    }

    public Boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean(privacyPolicy.getText());
    }


}
