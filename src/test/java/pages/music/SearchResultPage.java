package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SearchResultPage.class);

    private static final By PLAYLIST_BTN = By.xpath(".//*[@data-l='t,playlists']");

    SearchResultPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(PLAYLIST_BTN);
    }

    PlaylistsPage showFoundPlaylists() {
        click(PLAYLIST_BTN);
        log.debug("Clicked to show found playlists");
        return new PlaylistsPage(driver);
    }
}
