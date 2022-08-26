package tests.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.EntryPageSteps;
import steps.HomePageSteps;
import steps.LoginPageSteps;
import utils.CapabilitiesGenerator;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {
    protected static final String USERNAME = System.getenv().getOrDefault("username", PropertyReader.getProperty("username"));
    protected static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    protected WebDriver driver;
    protected LoginPageSteps loginPageSteps;
    protected HomePageSteps homePageSteps;
    protected EntryPageSteps entryPageSteps;

    @Step("Open browser")
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageSteps = new LoginPageSteps(driver);
        homePageSteps = new HomePageSteps(driver);
        entryPageSteps = new EntryPageSteps(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            takeScreenshot(driver);
            driver.quit();
        }
    }
}
