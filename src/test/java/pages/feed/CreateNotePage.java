package pages.feed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class CreateNotePage extends BasePage {
    private static final By POSTING_FORM_NOTE =
            By.xpath(".//*[@class='posting_itx-w']//*[@data-module='postingForm/mediaText']");
    private static final By SAVE_NOTE_BTN =
            By.xpath(".//*[@class='posting_f_ac']//*[@data-save='Сохранить' and @data-action='submit']");

    public CreateNotePage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(POSTING_FORM_NOTE, SAVE_NOTE_BTN);
    }

    public CreateNotePage typeNote(final String note) {
        type(POSTING_FORM_NOTE, note);
        return new CreateNotePage(driver);
    }

    public UserMainPage saveNote() {
        click(SAVE_NOTE_BTN);
        return new UserMainPage(driver);
    }
}
