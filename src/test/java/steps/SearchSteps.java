package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.core.Every;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import pages.SearchPage;

import java.util.List;

import static org.apache.groovy.util.concurrentlinkedhashmap.Weighers.iterable;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class SearchSteps extends ScenarioSteps {
    private SearchSteps searchSteps;
    private SearchPage searchPage;

    @Step
    public SearchSteps validateEachResultContains(String searchTerm) {

        List<String> searchResultsList = searchPage.getSearchResulstList();

        Assert.assertThat("SearchTerm " + searchTerm +
                " not found \n", searchResultsList, Every.everyItem(containsString(searchTerm)));
        return searchSteps;
    }

    @Then("Then I should find relevant results")
    @Step
    public SearchSteps validateEachResultContainsRelevant() {
        String[] relevantResults = {"HR", "hr", "Human Resources", "HUMAN RESOURCES", "H.R."};
//        for (String relevantResult : relevantResults
//        ) {
//            validateEachResultContains(relevantResult);
//        }
        validateEachResultContains(relevantResults);
        return searchSteps;

    }

    @Step
    public SearchSteps validateEachResultContains(String[] relevantResults) {

        List<String> searchResultsList = searchPage.getSearchResulstList();

         //  Assert.assertThat("SearchTerm " + searchTerm + " not found \n",
        //          searchResultsList, Every.everyItem(hasAny(searchTerm)));
        //Assert.assertThat(searchResultsList, hasItems(relevantResults));
        Assert.assertThat(searchResultsList,containsInAnyOrder(relevantResults));
        return searchSteps;
    }

    @Step
    public SearchSteps validateSearchPageIsLoaded() {
        Assert.assertTrue("Search page is not loaded", searchPage.isPageLoaded());
        return this;
    }
}