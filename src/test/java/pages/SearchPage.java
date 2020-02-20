package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageObject {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    public boolean isPageLoaded() {
        try {
            waitFor(ExpectedConditions.visibilityOf(searchResultsTotal));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<String> validateEachResultContains (String searchTerm) {
        List<String> SearchReasultList = new ArrayList<String>(); //must be initialized to use add method later
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", searchResult); //scroll to each searchResult
            SearchReasultList.add(searchResult.getText());
        }
        return SearchReasultList;
    }
}