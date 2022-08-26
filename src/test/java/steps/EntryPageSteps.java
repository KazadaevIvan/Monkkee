package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.EntryPage;

import static utils.AllureUtils.takeScreenshot;

public class EntryPageSteps {
    private EntryPage entryPage;

    public EntryPageSteps(WebDriver driver) {
        this.entryPage = new EntryPage(driver);
    }

    @Step("Input Entry text {text}")
    public EntryPageSteps inputEntryText(String text) {
        entryPage
                .inputText(text)
                .waitForEntryToBeSaved();
        takeScreenshot(entryPage.driver);
        return this;
    }

    @Step("Get entry id")
    public String getEntryId() {
        return entryPage.getEntryId();
    }

    @Step("Open Home page")
    public EntryPageSteps openHomePage() {
        entryPage
                .clickBackToOverViewButton()
                .isPageOpened();
        takeScreenshot(entryPage.driver);
        return this;
    }
}
