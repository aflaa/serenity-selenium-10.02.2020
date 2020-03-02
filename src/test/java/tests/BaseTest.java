package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

public class BaseTest {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver()//.version("80")
                .setup();
    }

    @Managed(driver = "chrome") //"firefox")
    WebDriver webDriver;

    @Steps
    UserSteps user;
}
