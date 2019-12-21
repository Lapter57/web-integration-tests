package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.feed.UserMainPage;
import pages.login.LoginPage;
import pages.music.MusicPage;

public class MusicTest extends TestBase {

    @Test
    public void addPlaylist() {
        final UserMainPage userMainPage = new LoginPage(driver).login(getTechnoBot());
        final MusicPage musicPage = userMainPage.clickMusicBtn();
        final int numPlaylistsBefore = musicPage.getMyPlaylists();
        musicPage.typeSearch("AC/DC")
                .performSearch()
                .showFoundPlaylists()
                .getFirstPlaylist()
                .addPlaylist();
        final int numPlaylistsAfter = musicPage.getMyPlaylists();
        Assert.assertEquals("Playlist wasn't added", numPlaylistsBefore + 1, numPlaylistsAfter);
    }
}
