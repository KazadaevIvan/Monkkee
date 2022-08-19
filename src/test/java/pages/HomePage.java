package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class HomePage extends BasePage {
    private final static String HOME_PAGE_URL = "entries";
    private final static By ENTRIES = By.className("entries");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(URL + HOME_PAGE_URL);
        return this;
    }

    @Step("Verify Home page is opened")
    @Override
    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ENTRIES));
        } catch (TimeoutException e) {
            Assert.fail("Page has not been loaded. Entries not found by locator " + ENTRIES);
        }
        return this;
    }
}
