package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

abstract class BasePage {

    private WebDriver driver;

    BasePage(final WebDriver driver) {
        this.driver = driver;
        waitPageLoad();
    }

    private void waitPageLoad() {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        for (final By by: elementsToWait()) {
            assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(by)),
                    "Field is not present or visible");
        }
    }

    public void type(final By by,
                     final String text) {
        final WebElement el = driver.findElement(by);
        el.clear();
        el.sendKeys(text);
    }

    public void click(final By by) {
        driver.findElement(by).click();
    }

    protected abstract List<By> elementsToWait();

}
