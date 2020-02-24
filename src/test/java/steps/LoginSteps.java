package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.LandingPage;
import pages.LoginChallengePage;

public class LoginSteps extends ScenarioSteps {
    private LandingPage landingPage;
    private LoginChallengePage loginChallengePage;

    @Step
    public LoginSteps login(String userEmail, String userPassword) {
        landingPage.open();
        landingPage.login(userEmail, userPassword);
        waitABit(4000);
        return this;
    }

    @Step
    public LoginSteps validatePageHeader(String expectedMessage) {
        Assert.assertEquals("Wrong header message:", expectedMessage,
                loginChallengePage.getHeaderMessageText()
        );
        return this;
    }
}
