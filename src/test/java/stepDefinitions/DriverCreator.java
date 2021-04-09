package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCreator {
    public WebDriver createBrowser(String browser) {
        WebDriver driver;

        browser.equals("gecko");
        System.setProperty("webdriver.gecko.driver", "/Users/stefanstoimenov/Downloads/Selenium/geckodriver");
        driver = new FirefoxDriver();
        return driver;
    }
}


