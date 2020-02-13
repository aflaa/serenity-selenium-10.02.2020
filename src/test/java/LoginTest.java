import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Managed(driver = "chrome")
    WebDriver webDriver;

    @Steps
    UserSteps userSteps;

    @Test
    public void negativeLoginTest() {
        String shortPasswordError = "The password you provided must have at least 6 characters";
        webDriver.get(userSteps.landingPage.pageLink);
        userSteps.login("a@b.c", "d");
        Assert.assertEquals( "Check alert for short Password:", shortPasswordError, userSteps.getAlertMessageText());
    }
}
