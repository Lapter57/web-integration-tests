package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class MusicPage extends BasePage {
    private static final By SEARCH = By.xpath(".//*[@data-l='t,search-input']//input");
    private static final By PLAYLISTS = By.xpath(".//wm-card[@data-l='t,card']");
    private static final By MY_MUSIC = By.xpath(".//*[@data-l='t,library']");

    public MusicPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(SEARCH, MY_MUSIC);
    }

    public int countMyPlaylists() {
        showMyMusic();
        return driver.findElements(PLAYLISTS).size();
    }

    public MusicPage addFirstPlaylist(final String name) {
        final MusicPage musicPage = typeSearch(name);
        final SearchResultPage searchResultPage = musicPage.performSearch();
        final PlaylistsPage playlistsPage = searchResultPage.showFoundPlaylists();
        playlistsPage.chooseFirstPlaylist().addPlaylist();
        return new MusicPage(driver);
    }

    private MusicPage typeSearch(final String search) {
        type(SEARCH, search);
        return new MusicPage(driver);
    }

    private SearchResultPage performSearch() {
        typeEnter(SEARCH);
        return new SearchResultPage(driver);
    }

    private MusicPage showMyMusic() {
        click(MY_MUSIC);
        return new MusicPage(driver);
    }
}
