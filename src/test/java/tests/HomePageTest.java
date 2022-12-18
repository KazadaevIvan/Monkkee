package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

import static utils.RandomNumberGenerator.getRandomNumber;

public class HomePageTest extends BaseTest {

    @Test(description = "Validation that new entry can be created", retryAnalyzer = RetryAnalyzer.class)
    public void newEntryShouldBeCreated() {
        loginPageSteps.login(USERNAME, PASSWORD);

        homePageSteps.startToCreateNewEntry();

        String expectedResult = "Hey! This is the first entry " + getRandomNumber();

        entryPageSteps.inputEntryText(expectedResult);

        String entryId = entryPageSteps.getEntryId();
        entryPageSteps.openHomePage();
        homePageSteps.verifyEntryWithIdHasText(entryId, expectedResult);
    }
}
