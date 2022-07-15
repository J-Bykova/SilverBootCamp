package definitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static support.TestContext.getDriver;


public class CommonStepDefs {
    WebDriver driver = getDriver();

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                driver.get("https://skryabin.com/market/quote.html");
                break;
            case "usps":
                driver.get("https://www.usps.com/");
                break;
            case "google":
                driver.get("https://www.google.com/");
                break;
            case "yahoo":
                driver.get("https://www.yahoo.com");
                break;
            case "bing":
                driver.get("https://www.bing.com");
                break;
            case "gibiru":
                driver.get("http://gibiru.com");
                break;
            case "duckDuckGo":
                driver.get("https://duckduckgo.com");
                break;
            case "swisscows":
                driver.get("https://swisscows.com");
                break;
            default:
                System.err.println("unknown page: " + page);
        }
    }
}

