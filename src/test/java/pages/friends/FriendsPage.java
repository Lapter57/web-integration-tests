package pages.friends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class FriendsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(FriendsPage.class);

    private static final By SEARCH_FRIENDS_BY_NAME_FIELD = By.xpath(".//*[@data-l='t,BY_NAME']//a");

    public FriendsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(SEARCH_FRIENDS_BY_NAME_FIELD);
    }

    public SearchFriendsPage searchFriendByName() {
        click(SEARCH_FRIENDS_BY_NAME_FIELD);
        log.debug("Clicked to open the search page for new friends");
        return new SearchFriendsPage(driver);
    }
}
