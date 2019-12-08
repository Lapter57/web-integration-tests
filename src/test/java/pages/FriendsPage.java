package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FriendsPage extends BasePage {
    private static final By SEARCH_FRIENDS_BY_NAME_FIELD = By.xpath(".//*[@data-l='t,BY_NAME']//a");

    public FriendsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(SEARCH_FRIENDS_BY_NAME_FIELD);
    }

    public void searchFriendByName() {
        Assert.assertTrue("Field of search friends by name is not visible",
                isElementVisible(SEARCH_FRIENDS_BY_NAME_FIELD));
        explicitWait(ExpectedConditions.elementToBeClickable(SEARCH_FRIENDS_BY_NAME_FIELD), 10, 500);
        click(SEARCH_FRIENDS_BY_NAME_FIELD);
    }
}
