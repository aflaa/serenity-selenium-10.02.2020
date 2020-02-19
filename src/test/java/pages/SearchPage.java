package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageObject {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

//    public static List<String> getSearchReasultList() {
//        List<String> resultTitles = searchResultsPage.getResultTitles();
//        resultTitles.stream().forEach(title -> assertThat(title.contains(keywords)));
//
//    }


//    public static int getSearchResultsNumber() {
//        return 0;
//    }


}
