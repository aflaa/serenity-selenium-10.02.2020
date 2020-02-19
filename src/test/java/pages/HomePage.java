package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@DefaultUrl("https://www.linkedin.com/feed/?trk=onboarding-landing")
public class HomePage extends PageObject {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    protected WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder and @role='combobox']")
    private WebElement searchField;


    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }


    public void searchForTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        waitFor(titleContains(searchTerm));
    }
}
