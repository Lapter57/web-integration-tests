package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.login.LoginPage;
import pages.music.MusicPage;
import pages.feed.UserMainPage;

public class MusicTest extends TestBase {

    @Test
    public void addPlaylist() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        MusicPage musicPage = userMainPage.clickMusicBtn();
        final int numPlaylistsBefore = musicPage.countMyPlaylists();
        musicPage = musicPage.addFirstPlaylist("AC/DC");
        final int numPlaylistsAfter = musicPage.countMyPlaylists();
        Assert.assertEquals("Playlist wasn't added", numPlaylistsBefore + 1, numPlaylistsAfter);
    }
}
