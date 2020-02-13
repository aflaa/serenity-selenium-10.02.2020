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
    UserSteps user;

    @Test
    public void negativeLoginTest() {
        String headerMessage = "Don't miss your next opportunity. Sign in to stay updated on your professional world.";
        user
                .login("a@b.c", "P@ssword")
                .validatePageHeader(headerMessage);
    }
}
