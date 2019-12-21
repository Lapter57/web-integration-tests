package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseElement;

public class Playlist extends BaseElement {
    private static final By ADD_PLAYLIST_BTN = By.xpath(".//*[@data-l='t,add' and @role='secondary']");

    private final WebElement playlist;

    public Playlist(final WebDriver driver,
                    final WebElement playlist) {
        super(driver);
        this.playlist = playlist;
    }

    public void addPlaylist() {
        click(ADD_PLAYLIST_BTN);
    }
}
