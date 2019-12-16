package pages.notes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Notes {
    private final List<WebElement> notes;
    private final WebDriver driver;

    public Notes(final WebDriver driver,
                 final List<WebElement> notes) {
        this.driver = driver;
        this.notes = notes;
    }

    public boolean isNoteExist(final String note) {
        return notes.stream()
                .map(WebElement::getText)
                .anyMatch(n -> n.equals(note));
    }
}
