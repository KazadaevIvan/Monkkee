package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginPageSteps;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected static final String USERNAME = System.getenv().getOrDefault("username", PropertyReader.getProperty("username"));
    protected static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    private WebDriver driver;
    protected LoginPageSteps loginPageSteps;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @Step("Open browser")
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageSteps = new LoginPageSteps(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
