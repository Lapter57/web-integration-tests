package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class PlaylistsPage extends BasePage {
    private static final By FIRST_PLAYLIST = By.xpath("(.//wm-card[@data-l='t,card'])[1]");
    private static final By ADD_PLAYLIST_BTN = By.xpath(".//*[@data-l='t,add' and @role='secondary']");

    PlaylistsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(FIRST_PLAYLIST, ADD_PLAYLIST_BTN);
    }

    PlaylistsPage chooseFirstPlaylist() {
        click(FIRST_PLAYLIST);
        return new PlaylistsPage(driver);
    }

    PlaylistsPage addPlaylist() {
        click(ADD_PLAYLIST_BTN);
        return new PlaylistsPage(driver);
    }
}
