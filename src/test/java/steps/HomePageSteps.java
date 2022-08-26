package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.EntryPage;
import pages.HomePage;

import static utils.AllureUtils.takeScreenshot;
import static org.testng.Assert.assertEquals;

public class HomePageSteps {
    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    @Step("Start to create new entry")
    public HomePageSteps startToCreateNewEntry() {
        homePage
                .clickCreateAnEntryButton()
                .isPageOpened();
        takeScreenshot(homePage.driver);
        return this;
    }

    @Step("Verify entry with id {id} has text {text}")
    public HomePageSteps verifyEntryWithIdHasText(String id, String text) {
        assertEquals(homePage.getEntryWithIdText(id), text);
        takeScreenshot(homePage.driver);
        return this;
    }
}
