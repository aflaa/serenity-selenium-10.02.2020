package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.SearchPage;

public class SearchSteps extends ScenarioSteps {
    private SearchSteps searchSteps;
    private SearchPage searchPage;

    @Step
    public SearchSteps validateEachResultContains(String searchTerm) {
        searchPage.validateEachResultContains(searchTerm);
        return searchSteps;
    }

    @Step
    public SearchSteps validateSearchPageIsLoaded() {
        Assert.assertTrue("Search page is not loaded", searchPage.isPageLoaded());
        return this;
    }
}
