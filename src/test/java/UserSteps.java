import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps {

    LandingPage landingPage;

    @Step
    public void login(String userEmail, String userPassword) {
        landingPage.login(userEmail, userPassword);
    }

    public String getAlertMessageText() {
        return landingPage.getAlertMessageText();
    }
}
