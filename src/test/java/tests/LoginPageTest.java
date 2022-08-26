package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test(description = "Validation that user could login with valid credentials")
    public void userShouldBeLoggedIn() {
        loginPageSteps.login(USERNAME, PASSWORD);
    }
}
