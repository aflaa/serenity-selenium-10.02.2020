package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SearchTest extends BaseTest {
    protected String userEmail = "altestqa@gmail.com";
    protected String userPW = "Aqqq2222";

    private final String searchTerm;

    public SearchTest(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"HR"},
                {"hr"},
                {"Human Resources"}
        });
    }

    @Before
    public void before() {
        user
                .auth()
                .openLandingPage()
                .login(userEmail, userPW);
    }

    @Test
    public void searchBySearchTermTest() {
        String[] relevantResults = {"HR", "hr", "Human Resources", "HUMAN RESOURCES"};
        user
                .validatePageTitle("LinkedIn")
                .homePage()
                .validateHomePageIsLoaded()
                .searchFor(searchTerm);
        user
                .validatePageTitle("\"" + searchTerm + "\" | Search | LinkedIn")
                .searchPage()
                .validateSearchPageIsLoaded()
                .validateEachResultContains(searchTerm)
        ;
    }
}


