package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static utils.AllureUtils.takeScreenshot;

public class LoginPageSteps {
    private final LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("Login with username '{username}' and password '{password}'")
    public LoginPageSteps login(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password)
                .isPageOpened();
        takeScreenshot(loginPage.driver);
        return this;
    }
}
