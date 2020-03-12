package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.core.Every;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import pages.SearchPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchSteps extends ScenarioSteps {
    private SearchSteps searchSteps;
    private SearchPage searchPage;

    @Then("I should see $searchTerm in each search result")
    @Step
    public SearchSteps validateEachResultContains(String searchTerm) {

        List<String> searchResultsList = searchPage.getSearchResulstList();

        Assert.assertThat("SearchTerm " + searchTerm +
                " not found \n", searchResultsList, Every.everyItem  //(containsString(searchTerm)));
                (anyOf(containsString(searchTerm), containsString(searchTerm.toUpperCase()))));
        return searchSteps;
    }


    @Step
    public SearchSteps validateSearchPageIsLoaded() {
        Assert.assertTrue("Search page is not loaded", searchPage.isPageLoaded());
        return this;
    }
}