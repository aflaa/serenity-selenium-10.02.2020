package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginChallengePage;
import pages.SearchPage;

import java.util.List;

import static org.junit.Assert.assertThat;

public class UserSteps extends ScenarioSteps {

    private LandingPage landingPage;
    private LoginChallengePage loginChallengePage;
    private HomePage homePage;

    @Step
    public UserSteps login(String userEmail, String userPassword) {
        landingPage.open();
        landingPage.login(userEmail, userPassword);
        waitABit(60000);
        return this;
    }

    @Step
    public UserSteps validatePageHeader(String expectedMessage) {
      //  String actualMessage = loginChallengePage.element(loginChallengePage.headerMessage).getText();
        Assert.assertEquals("Wrong header message:", expectedMessage,
                //actualMessage
                loginChallengePage.getHeaderMessageText()
        );
        return this;
    }

    @Step
    public UserSteps validateSucceedLogin() {
        Assert.assertTrue("Home page is not loaded", homePage.isPageLoaded());
        return this;
    }

    @Step
    public UserSteps searchForTerm(String searchTerm) {
        homePage.searchForTerm(searchTerm);
        return this;

    }
//    @Step
//    public void validateSearchResult(String searchTerm) {
//        List<String> resultTitles = SearchPage.getResultTitles();
//        resultTitles.stream().forEach(assertThat(title.contains(searchTerm)));
//    }

//    @Step
//    public void validateSearchResult() {
//        Assert.assertEquals(SearchPage.getSearchResultsNumber(), 8359729, "Wrong number of search results on Search Page");
//
//        List<String> searchResultsList = SearchPage.getSearchReasultList();
//
//        for (String searchResult : searchResultsList) {
//            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
//                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
//        }
//    }
}
