package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@At("https://www.linkedin.com/feed/")
public class HomePage extends PageObject {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    protected WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder and @role='combobox']")
    private WebElement searchField;


    public  boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        waitFor(titleContains(searchTerm));
    }
}
