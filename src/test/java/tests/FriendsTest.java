package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.FriendsPage;
import pages.LoginPage;
import pages.SearchPage;
import pages.UserMainPage;

public class FriendsTest extends TestBase {

    private static final String BAD_GUY = "TechoBot12 TechoBot12";

    @Test
    public void inabilityAddUserWhoBlockedYou() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickFriendsBtn();
        final FriendsPage friendsPage = new FriendsPage(driver);
        friendsPage.searchFriendByName();
        final SearchPage searchPage = new SearchPage(driver);
        searchPage.addFriend(BAD_GUY);
        Assert.assertTrue("User was added as friend", searchPage.isErrorsExist());
    }
}
