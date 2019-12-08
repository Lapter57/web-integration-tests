package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class UserMainPage extends BasePage {

    private static final By OPEN_NOTE_LINK = By.xpath(".//*[@class='pf-head_cnt']//a");
    private static final By NOTES_BTN = By.xpath(".//*[@class='nav-side __navigation']//a[@data-l='t,userStatuses']");
    private static final By MY_SETTINGS = By.xpath(".//*[@data-l='t,avaActionMenuUser']//a[@href='/settings']");
    private static final By POSTING_FORM_NOTE =
            By.xpath(".//*[@class='posting_itx-w']//*[@data-module='postingForm/mediaText']");
    private static final By SAVE_NOTE_BTN =
            By.xpath(".//*[@class='posting_f_ac']//*[@data-save='Сохранить' and @data-action='submit']");
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

    public void createNote(final String note) {
        clickNote();
        typeNote(note);
        saveNote();
    }

    private void clickNote() {
        Assert.assertTrue("Keep area is not visible", isElementVisible(OPEN_NOTE_LINK));
        explicitWait(ExpectedConditions.elementToBeClickable(OPEN_NOTE_LINK), 10, 500);
        click(OPEN_NOTE_LINK);
    }

    private void typeNote(final String note) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SAVE_NOTE_BTN), 10, 500);
        Assert.assertTrue("Writing area of note is not visible", isElementVisible(POSTING_FORM_NOTE));
        type(POSTING_FORM_NOTE, note);
    }

    private void saveNote() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SAVE_NOTE_BTN), 10, 500);
        Assert.assertTrue("Save note button is not visible", isElementVisible(SAVE_NOTE_BTN));
        Assert.assertTrue("Save note button is disabled", isElementEnabled(SAVE_NOTE_BTN));
        click(SAVE_NOTE_BTN);
    }

    public void clickNotesBtn() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(NOTES_BTN), 10, 500);
        Assert.assertTrue("Notes button is not visible", isElementVisible(NOTES_BTN));
        explicitWait(ExpectedConditions.elementToBeClickable(NOTES_BTN), 10, 500);
        click(NOTES_BTN);
    }

    public void clickMySettingsBtn() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(MY_SETTINGS), 10, 500);
        Assert.assertTrue("My settings is not visible", isElementVisible(MY_SETTINGS));
        explicitWait(ExpectedConditions.elementToBeClickable(MY_SETTINGS), 10, 500);
        click(MY_SETTINGS);
    }

    public void clickMusicBtn() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(MUSIC_TOOLBAR_BTN), 10, 500);
        Assert.assertTrue("Music button is not visible", isElementVisible(MUSIC_TOOLBAR_BTN));
        explicitWait(ExpectedConditions.elementToBeClickable(MUSIC_TOOLBAR_BTN), 10, 500);
        click(MUSIC_TOOLBAR_BTN);
    }

    public void clickFriendsBtn() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(FRIENDS_TOOLBAR_BTN), 10, 500);
        Assert.assertTrue("Friends button is not visible", isElementVisible(FRIENDS_TOOLBAR_BTN));
        explicitWait(ExpectedConditions.elementToBeClickable(FRIENDS_TOOLBAR_BTN), 10, 500);
        click(FRIENDS_TOOLBAR_BTN);
    }
}
