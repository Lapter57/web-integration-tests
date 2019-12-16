package pages.notes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class NotesPage extends BasePage {
    private static final By NOTES =
            By.xpath(".//*[@class='feed' and @tsid='userStatusShares']//*[@class='media-text_cnt']");
    private static final By MIDDLE_COLUMN = By.id("middleColumn");

    public NotesPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(MIDDLE_COLUMN);
    }

    public boolean isNoteExist(final String note) {
        final Notes notes = new Notes(driver, driver.findElements(NOTES));
        return notes.isNoteExist(note);
    }
}
