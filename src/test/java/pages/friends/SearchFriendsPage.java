package pages.friends;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class SearchFriendsPage extends BasePage {
    private static final By SEARCH = By.id("query_usersearch");
    private static final String ADD_FRIEND_BTN_TEMPLATE =
            ".//a[contains(@href, 'cmd=AddFriendButton') and contains(@href, 'st.query=%s')]";
    private static final By ERRORS = By.xpath(".//span[@class='c-red' and string-length(text()) > 0]");

    public SearchFriendsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(SEARCH);
    }

    public void typeSearch(final String search) {
        type(SEARCH, search);
    }

    public SearchFriendsPage addFriend(final String name) {
        typeSearch(name);
        final String query = name.replace(" ", "+");
        final By addFriendBtn = By.xpath(String.format(ADD_FRIEND_BTN_TEMPLATE, query));
        explicitWait(ExpectedConditions.visibilityOfElementLocated(addFriendBtn), 10, 500);
        Assert.assertTrue("Add new friend button is not visible", isElementVisible(addFriendBtn));
        click(addFriendBtn);
        return new SearchFriendsPage(driver);
    }

    public boolean isErrorsExist() {
        return driver.findElements(ERRORS).size() != 0;
    }
}
