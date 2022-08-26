package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static utils.AllureUtils.takeScreenshot;
import static utils.RandomNumberGenerator.getRandomNumber;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void login() {
        loginPageSteps.login(USERNAME, PASSWORD);
    }

    @Test(description = "Validation that new entry can be created")
    public void newEntryShouldBeCreated() {
        homePageSteps.startToCreateNewEntry();

        String expectedResult = "Hey! This is the first entry " + getRandomNumber();

        entryPageSteps.inputEntryText(expectedResult);
        takeScreenshot(driver);

        String entryId = entryPageSteps.getEntryId();
        entryPageSteps.openHomePage();
        homePageSteps.verifyEntryWithIdHasText(entryId, expectedResult);
    }
}
