package pages.feed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.friends.FriendsPage;
import pages.music.MusicPage;
import pages.notes.NotesPage;
import pages.settings.SettingsPage;

import java.util.List;

public class UserMainPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(UserMainPage.class);

    private static final By OPEN_NOTE_LINK = By.xpath(".//*[@class='pf-head_cnt']//a");
    private static final By NOTES_BTN = By.xpath(".//*[@class='nav-side __navigation']//a[@data-l='t,userStatuses']");
    private static final By MY_SETTINGS = By.xpath(".//*[@data-l='t,avaActionMenuUser']//a[@href='/settings']");
    private static final By MUSIC_TOOLBAR_BTN =
            By.xpath(".//*[@data-l='t,navigationToolbar']//*[@data-module='music2/toolbar-button']");
    private static final By FRIENDS_TOOLBAR_BTN =
            By.xpath(".//*[@data-l='t,navigationToolbar']//*[@data-l='t,friends']//a");

    public UserMainPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(OPEN_NOTE_LINK, NOTES_BTN, MY_SETTINGS,
                MUSIC_TOOLBAR_BTN, FRIENDS_TOOLBAR_BTN);
    }

    public UserMainPage createNote(final String note) {
        final CreateNotePage createNotePage = clickNote();
        return createNotePage.typeNote(note).saveNote();
    }

    private CreateNotePage clickNote() {
        click(OPEN_NOTE_LINK);
        log.debug("Clicked to open a form to create a new note");
        return new CreateNotePage(driver);
    }

    public NotesPage clickNotesBtn() {
        click(NOTES_BTN);
        log.debug("Clicked to open a page of notes");
        return new NotesPage(driver);
    }

    public SettingsPage clickMySettingsBtn() {
        click(MY_SETTINGS);
        log.debug("Clicked to open a settings page");
        return new SettingsPage(driver);
    }

    public MusicPage clickMusicBtn() {
        click(MUSIC_TOOLBAR_BTN);
        log.debug("Clicked to open a music page");
        return new MusicPage(driver);
    }

    public FriendsPage clickFriendsBtn() {
        click(FRIENDS_TOOLBAR_BTN);
        log.debug("Clicked to open a friends page");
        return new FriendsPage(driver);
    }
}
