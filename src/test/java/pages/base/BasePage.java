package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {
    public final static String URL = "https://my.monkkee.com/#/";
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    abstract public BasePage openPage();

    abstract public BasePage isPageOpened();
}