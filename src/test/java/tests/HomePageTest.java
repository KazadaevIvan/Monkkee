package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static utils.RandomNumberGenerator.getRandomNumber;

public class HomePageTest extends BaseTest {

    @BeforeMethod(description = "Login user")
    public void login() {
        loginPageSteps.login(USERNAME, PASSWORD);
    }

    @Test(description = "Validation that new entry can be created")
    public void newEntryShouldBeCreated() {
        homePageSteps.startToCreateNewEntry();

        String expectedResult = "Hey! This is the first entry " + getRandomNumber();

        entryPageSteps.inputEntryText(expectedResult);

        String entryId = entryPageSteps.getEntryId();
        entryPageSteps.openHomePage();
        homePageSteps.verifyEntryWithIdHasText(entryId, expectedResult);
    }

    @AfterMethod(description = "Logout user")
    public void logout() {
        homePageSteps.logout();
    }
}
