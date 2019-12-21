package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class PlaylistsPage extends BasePage {
    private static final By FIRST_PLAYLIST = By.xpath("(.//wm-card[@data-l='t,card'])[1]");

    public PlaylistsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(FIRST_PLAYLIST);
    }

    public Playlist getFirstPlaylist() {
        click(FIRST_PLAYLIST);
        return new Playlist(driver, driver.findElement(FIRST_PLAYLIST));
    }
}
