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
        user.login("", "");

    }

    @Test
    public void searchBySearchTermTest() {

        String searchTerm = "hr";
        user
                .login(userEmail, userPW)
                .validateSucceedLogin()
                .searchForTerm(searchTerm)
        // .validateSearchResult(searchTerm)
        ;
    }
}


