package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.SearchPage;

import java.util.List;

public class SearchSteps extends ScenarioSteps {
    private SearchSteps searchSteps;
    private SearchPage searchPage;

    @Step
    public SearchSteps validateEachResultContains(String searchTerm) {

        List<String> searchResultsList = searchPage.getSearchResultList();

        for (String searchResult : searchResultsList) {
            Assert.assertTrue("SearchTerm " + searchTerm+ " not found in:\n" + searchResult,
                    searchResult.toLowerCase().contains(searchTerm.toLowerCase()));
        }
        return searchSteps;
    }

    @Step
    public SearchSteps validateSearchPageIsLoaded() {
        Assert.assertTrue("Search page is not loaded", searchPage.isPageLoaded());
        return this;
    }
}
