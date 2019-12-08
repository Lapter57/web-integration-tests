package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MusicPage;
import pages.UserMainPage;

public class MusicTest extends TestBase {

    @Test
    public void addPlaylist() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickMusicBtn();
        final MusicPage musicPage = new MusicPage(driver);
        final int numPlaylistsBefore = musicPage.countMyPlaylists();
        musicPage.addFirstPlaylist("AC/DC");
        final int numPlaylistsAfter = musicPage.countMyPlaylists();
        Assert.assertEquals("Playlist wasn't added", numPlaylistsBefore + 1, numPlaylistsAfter);
    }
}
