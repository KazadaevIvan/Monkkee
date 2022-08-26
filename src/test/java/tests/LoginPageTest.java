package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test(description = "Validation that user could login with valid credentials")
    public void userShouldBeLoggedIn() {
        loginPageSteps.login(USERNAME, PASSWORD);
    }

    @AfterMethod(description = "Logout user")
    public void logout() {
        homePageSteps.logout();
    }
}
