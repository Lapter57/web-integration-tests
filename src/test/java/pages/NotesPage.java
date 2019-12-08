package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getNotes() {
        return driver.findElements(NOTES).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
