package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private static final By USERNAME_INPUT = By.id("login");
    private static final By PASSWORD_INPUT = By.id("password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    @Override
    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Verify Login page is opened")
    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    @Step("Login with username '{username}' and password '{password}'")
    public HomePage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
