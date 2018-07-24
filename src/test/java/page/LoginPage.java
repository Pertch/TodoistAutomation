package page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 7/20/18.
 */
public class LoginPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "email_exists_input")
    private WebElement emailField;

    @FindBy(id = "btn_continue_with_email")
    private WebElement continueWithEmailButton;

    @FindBy(id = "log_in_password")
    private WebElement passwordField;

    @FindBy(id = "btn_log_in")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setEmail(String email) throws InterruptedException {
        Thread.sleep(7000);
        emailField.sendKeys(email);
    }

    public void clickContinueWithEmailButton(){
        continueWithEmailButton.click();
    }

    public void setPassword(String password) throws InterruptedException {
        Thread.sleep(7000);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();

    }

}
