import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageObject {
    @Managed(driver = "chrome")
    WebDriver webDriver;
    String pageLink = "https://www.linkedin.com/";

    @FindBy(xpath = "//input[@name='session_key']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@name='session_password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@aria-label='i18n_sign-in']")
    private WebElement loginButton;

     @FindBy(xpath = ("//p[@class='input__message']"))
    private WebElement userPasswordAlertMessage;

    public void login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        loginButton.click();
    }

    public String getAlertMessageText() {
        return userPasswordAlertMessage.getText();
    }
}
