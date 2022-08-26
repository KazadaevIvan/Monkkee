package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "entries";
    private static final By SEARCH_INPUT = By.xpath("//input[@type='search']");
    private static final By CREATE_AN_ENTRY_BUTTON = By.id("create-entry");
    private static final String ENTRY_WITH_ID_TEXT = "//a[@href='#/entries/%s']/div[@ng-bind-html='entry.body']";
    private static final By LOGOUT_BUTTON = By.xpath("//button[@class='user-menu-btn']");

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        } catch (TimeoutException e) {
            Assert.fail("Page has not been loaded. Search input not found by locator " + SEARCH_INPUT);
        }
        return this;
    }

    @Step("Click Create An Entry button")
    public EntryPage clickCreateAnEntryButton() {
        driver.findElement(CREATE_AN_ENTRY_BUTTON).click();
        return new EntryPage(driver);
    }

    @Step("Get entry with id {id} text")
    public String getEntryWithIdText(String id) {
        return driver.findElement(By.xpath(String.format(ENTRY_WITH_ID_TEXT, id))).getText();
    }

    @Step("Click Logout button")
    public LoginPage clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }
}
