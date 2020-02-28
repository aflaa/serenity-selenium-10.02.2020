package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SuccessfulLoginTest extends BaseTest {

    private final String userEmail;
    private final String userPW;

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"altestqa@gmail.com", "Aqqq2222"},
                {"ALTESTQA@GMAIL.COM", "Aqqq2222"},
                {"ALTESTQA@gmail.com", "Aqqq2222"}
        });
    }

    public SuccessfulLoginTest(String userEmail, String userPW) {
        this.userEmail = userEmail;
        this.userPW = userPW;
    }

    @Test
    public void positiveLoginTest() {
        user
                .auth()
                .openLandingPage()
                .login(userEmail, userPW);
        user
                .validatePageTitle("LinkedIn")
                .homePage()
                .validateHomePageIsLoaded();
    }
}
