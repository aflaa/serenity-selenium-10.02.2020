package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class SearchTest extends BaseTest {
    protected String userEmail = "altestqa@gmail.com";
    protected String userPW = "Aqqq2222";

    @Before
    public void before() {
        user
                .auth()
                .login(userEmail, userPW);
    }

    @Test
    public void searchBySearchTermTest() {
        String searchTerm = "hr";
        user
                .validatePageTitle("LinkedIn")
                .homePage()
                .validateHomePageIsLoaded()
                .searchFor(searchTerm);
        user
                .validatePageTitle("\""+ searchTerm + "\" | Search | LinkedIn")
                .searchPage()
                .validateSearchPageIsLoaded()
                .validateEachResultContains(searchTerm)
        ;
    }
}


