import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginChallenge extends PageObject {

    @FindBy(xpath = "//h1/../p")
    WebElement headerMessage;

//    public String getHeaderMessageText() {
//        return headerMessage.getText();
//    }
}
