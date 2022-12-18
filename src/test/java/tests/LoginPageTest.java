package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class LoginPageTest extends BaseTest {

    @Test(description = "Validation that user could login with valid credentials", retryAnalyzer = RetryAnalyzer.class)
    public void userShouldBeLoggedIn() {
        loginPageSteps.login(USERNAME, PASSWORD);
    }
}
