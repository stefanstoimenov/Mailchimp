package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class MyStepDefinitions {
    private WebDriver driver;
    private String output;

    @Given("I have entered {string} as a browser")
    public void i_have_entered_as_a_browser(String browser) {
        DriverCreator creator = new DriverCreator();
        driver = creator.createBrowser(browser);
    }

    @Given("I have opened {string} as a webpage")
    public void i_have_opened_as_a_webpage(String arg0) throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);

    }

    @And("I have entered {string} as a mail")
    public void i_have_entered_mail_as_a_mail(String mail) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(mail);
        Thread.sleep(3000);
    }

    @Given("I have also entered {string} as an username")
    public void i_have_also_entered_username_as_an_username(String username) throws InterruptedException {
        WebElement inputUsername = driver.findElement(By.id("new_username"));
        if (username.equals("hv23486em9")) {
            username = UUID.randomUUID().toString().replace("-", "");
            inputUsername.sendKeys(username);
        } else if (username.equals("qwertyuiopasdfghjklzxcvbnm123456789qwertyuiopasdfghjklzxcvbnm123456789qwertyuiopasdfghjklzxcvbnm123456789")) {
            inputUsername.sendKeys(username);
        } else {
            inputUsername.sendKeys(username);
        }
        Thread.sleep(3000);
    }

    @Given("I have also entered {string} as a password")
    public void i_have_also_entered_password_as_a_password(String password) throws TimeoutException, InterruptedException {
        WebElement passwordBox = driver.findElement(By.id("new_password"));
        passwordBox.sendKeys(password);
        Thread.sleep(3000);
    }

    @When("I press sign up")
    public void i_press_sign_up() throws InterruptedException {
        driver.findElement(By.id("create-account")).click();
        Thread.sleep(3000);
    }

    @Then("I should get the correct {string}")
    public void i_should_get_the_correct_output(String finalOutput) throws ElementClickInterceptedException {

        if (finalOutput.equals("Check your email")) {
            output = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3")).getText();
        } else if (finalOutput.equals("Enter a value less than 100 characters long")) {
            output = driver.findElement(By.className("invalid-error")).getText();
        } else if (finalOutput.equals("Another user with this username already exists. Maybe it's your evil twin. Spooky.")) {
            output = driver.findElement(By.className("invalid-error")).getText();
        } else {
            output = driver.findElement(By.className("invalid-error")).getText();
        }

        assertEquals(finalOutput, output);

        driver.quit();
    }
}

