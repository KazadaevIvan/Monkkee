package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    private final static By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private final static By USERNAME_INPUT = By.id("login");
    private final static By PASSWORD_INPUT = By.id("password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    public LoginPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}
