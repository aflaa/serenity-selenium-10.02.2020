package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SearchPage;

public class SearchSteps extends ScenarioSteps {
    private SearchSteps searchSteps;
    private SearchPage searchPage;

    @Step
    public SearchSteps validateEachResultContains(String searchTerm) {
        searchPage.validateEachResultContains(searchTerm);
        return searchSteps;
    }

    public SearchSteps validateSearchPageIsLoaded() {
        return searchSteps;
    }
}
