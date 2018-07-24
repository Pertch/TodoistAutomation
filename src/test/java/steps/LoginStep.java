package steps;

import io.appium.java_client.AppiumDriver;
import page.HomePage;
import page.LoginPage;
import page.MainPage;


/**
 * Created by user on 7/21/18.
 */
public class LoginStep {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    private AppiumDriver driver;
    protected static final String EMAIL = "testappricodetodoist2@gmail.com";
    protected static final String USERNAME = "testAppricode";
    protected static final String PASSWORD = "test123!@#";

    public LoginStep(AppiumDriver driver){
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        mainPage.clickWithEmailButton();
        loginPage.setEmail(EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        try {
            if (homePage.checkTimeZonePopup()) {
                homePage.clickTimeZoneYesButton();
            }
        } catch (Exception e) {
        }
    }
}
