import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    public WebDriver driver;
    WebDriverWait wait;
    Logger logger;
    @Before
    public void setUp() {
        logger = Logger.getLogger("TestAutomation");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //after update, it bypasses the error
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Window maximized");
    }
    @Given("The existing user is on the login page")
    public void theExistingUserIsOnTheLoginPage() {
        driver.get("https://demo.guru99.com/v4/index.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame("gdpr-consent-notice");
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id='save']/span[1]/div/span"));
        acceptCookies.click();
    }
    @When("Types {string}")
    public void types(String arg0) {
        WebElement username = driver.findElement(By.name("uid"));
        username.sendKeys(arg0);
    }
    @And("password {string}")
    public void password(String arg0) {
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(arg0);
    }
    @And("clicks login")
    public void clicksLogin() {
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();
    }

    @Then("is signed in succesfully")
    public void isSignedInSuccesfully() {
        String expectedLogin = "mngr495031";
        String actualLogin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        assertEquals(true, actualLogin.contains(expectedLogin));
        driver.quit();
    }
}
