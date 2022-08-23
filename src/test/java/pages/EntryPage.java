package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class EntryPage extends BasePage {
    public final static By TEXT_INPUT = By.id("editable");
    public final static By BACK_TO_OVER_VIEW_BUTTON = By.xpath("//a[@id='back-to-overview']/i");
    public final static By SAVED_ICON = By.xpath("//span[contains(@class, 'cke_savetoggle_text') and text()='saved']");

    public EntryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EntryPage openPage() {
        System.out.println("Don't do this!");
        return this;
    }

    @Step("Verify Entry page is opened")
    @Override
    public EntryPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_INPUT));
        } catch (TimeoutException e) {
            Assert.fail("Page has not been loaded. Text input not found by locator " + TEXT_INPUT);
        }
        return this;
    }

    @Step("Input text {text}")
    public EntryPage inputText(String text) {
        driver.findElement(TEXT_INPUT).sendKeys(text);
        return this;
    }

    @Step("Wait for entry to be saved")
    public EntryPage waitForEntryToBeSaved() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVED_ICON));
        } catch (TimeoutException e) {
            Assert.fail("Saved icon hasn't been found by locator " + SAVED_ICON);
        }
        return this;
    }

    @Step("Get entry id")
    public String getEntryId() {
        return driver.getCurrentUrl().split("#/entries/")[1];
    }

    @Step("Open Home page")
    public HomePage clickBackToOverViewButton() {
        driver.findElement(BACK_TO_OVER_VIEW_BUTTON).click();
        return new HomePage(driver);
    }
}
