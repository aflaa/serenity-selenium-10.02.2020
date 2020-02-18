package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {
        String headerMessage = "Don't miss your next opportunity. Sign in to stay updated on your professional world.";
        user
                .login("a@b.c", "P@ssword")
                .validatePageHeader(headerMessage);
    }
}
