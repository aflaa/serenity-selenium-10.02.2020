import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageObject {

//    @FindBy(xpath = "//*[@id='username']")
//    private WebElement userEmailField;
//
//    @FindBy(xpath = "//*[@id='password']")
//    private WebElement userPasswordField;
//
//    @FindBy(xpath = "//button[@aria-label='Sign in']")
//    private WebElement loginButton;

//    @FindBy(xpath = "//*[@data-tracking-will-navigate='Sign in']")
//    private WebElement signinButton;

    @FindBy(xpath = "//input[@name='session_key']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@name='session_password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@aria-label='i18n_sign-in']")
    private WebElement loginButton;

    public void login(String userEmail, String userPassword) {
     //   signinButton.click();
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        loginButton.click();
    }
}
