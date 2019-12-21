package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class BasePage extends BaseElement {
    public BasePage(final WebDriver driver) {
        super(driver);
        waitPageLoad();
    }

    private void waitPageLoad() {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        for (final By by: elementsToWait()) {
            assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(by)),
                    "Field is not present or visible");
        }
    }

    protected abstract List<By> elementsToWait();
}
