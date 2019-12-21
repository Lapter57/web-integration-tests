package pages.notes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseElement;

public class Note extends BaseElement {
    private static final By TEXT = By.xpath(".//*[@class='media-text_cnt']");
    private final WebElement note;

    public Note(final WebDriver driver,
                final WebElement note) {
        super(driver);
        this.note = note;
    }

    public String getText() {
        try {
            return note.findElement(TEXT).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
