import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.linkedin.com/")
public class LandingPage extends PageObject {

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
