package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.friends.FriendsPage;
import pages.login.LoginPage;
import pages.friends.SearchFriendsPage;
import pages.feed.UserMainPage;

public class FriendsTest extends TestBase {
    private static final String BAD_GUY = "TechoBot12 TechoBot12";

    @Test
    public void inabilityAddUserWhoBlockedYou() {
        final UserMainPage userMainPage = new LoginPage(driver).login(getTechnoBot());
        final FriendsPage friendsPage = userMainPage.clickFriendsBtn();
        SearchFriendsPage searchPage = friendsPage.searchFriendByName();
        searchPage = searchPage.addFriend(BAD_GUY);
        Assert.assertTrue("User was added as friend", searchPage.isErrorsExist());
    }
}
