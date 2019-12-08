package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MusicPage extends BasePage {
    private static final By SEARCH = By.xpath(".//*[@data-l='t,search-input']//input");
    private static final By PLAYLIST_BTN = By.xpath(".//*[@data-l='t,playlists']");
    private static final By PLAYLISTS = By.xpath(".//wm-card[@data-l='t,card']");
    private static final By FIRST_PLAYLIST = By.xpath("(.//wm-card[@data-l='t,card'])[1]");
    private static final By ADD_PLAYLIST_BTN = By.xpath(".//*[@data-l='t,add' and @role='secondary']");
    private static final By MY_MUSIC = By.xpath(".//*[@data-l='t,library']");

    public MusicPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(SEARCH);
    }

    public int countMyPlaylists() {
        showMyMusic();
        return driver.findElements(PLAYLISTS).size();
    }

    public void addFirstPlaylist(final String name) {
        typeSearch(name);
        performSearch();
        showFoundPlaylists();
        chooseFirstPlaylist();
        addPlaylist();
    }

    private void typeSearch(final String search) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SEARCH), 10, 500);
        Assert.assertTrue("Field of search is not visible", isElementVisible(SEARCH));
        type(SEARCH, search);
    }

    private void performSearch() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SEARCH), 10, 500);
        Assert.assertTrue("Field of search is not visible", isElementVisible(SEARCH));
        typeEnter(SEARCH);
    }

    private void showFoundPlaylists() {
        Assert.assertTrue("Add compilation button is not visible", isElementVisible(PLAYLIST_BTN));
        explicitWait(ExpectedConditions.elementToBeClickable(PLAYLIST_BTN), 10, 500);
        click(PLAYLIST_BTN);
    }

    private void chooseFirstPlaylist() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(FIRST_PLAYLIST), 10, 500);
        Assert.assertTrue("Playlist is not visible", isElementVisible(FIRST_PLAYLIST));
        click(FIRST_PLAYLIST);
    }

    private void addPlaylist() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(ADD_PLAYLIST_BTN), 10, 500);
        Assert.assertTrue("Playlist is not visible", isElementVisible(ADD_PLAYLIST_BTN));
        click(ADD_PLAYLIST_BTN);
    }

    private void showMyMusic() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(MY_MUSIC), 10, 500);
        Assert.assertTrue("Playlist is not visible", isElementVisible(MY_MUSIC));
        click(MY_MUSIC);
    }
}
