package pages;

import com.google.common.base.Preconditions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseElement {
    private static final Logger log = LoggerFactory.getLogger(BaseElement.class);
    protected final WebDriver driver;

    protected BaseElement(final WebDriver driver) {
        this.driver = driver;
    }

    protected void type(final By by,
                        final String text) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(by), 10, 500);
        final WebElement el = driver.findElement(by);
        el.clear();
        el.sendKeys(text);
        log.debug("Typed {} on the {}", text, by);
    }

    protected void click(final By by) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(by), 10, 500);
        driver.findElement(by).click();
        log.debug("Clicked on the {}", by);
    }

    protected void typeEnter(final By by) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(by), 10, 500);
        driver.findElement(by).sendKeys(Keys.RETURN);
        log.debug("Typed enter on the {}", by);
    }

    protected boolean isElementVisible(final By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementPresent(final By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementEnabled(final By by) {
        try {
            return driver.findElement(by).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean explicitWait(final ExpectedCondition<?> condition,
                                   final long maxCheckTimeInSeconds,
                                   final long millisecondsBetweenChecks) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver shouldnt be null");
        }
        Preconditions.checkNotNull(condition, "Condition must be not null");
        Preconditions.checkArgument(TimeUnit.MINUTES.toSeconds(3) > maxCheckTimeInSeconds, "Max check time in seconds should be less than 3 minutes");
        checkConditionTimeouts(maxCheckTimeInSeconds, millisecondsBetweenChecks);
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait explicitWait = new WebDriverWait(driver, maxCheckTimeInSeconds, millisecondsBetweenChecks);
            explicitWait.until(condition);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    /**
     * Проверяет таймаут провекри условия и интервал между проверками: таймаут
     * должен быть больше нуля, интервал проверки должен быть больше нуля
     * интервал между проверками умноженный на 1000 должен быть меньше таймаута
     * проверки
     *
     * @param maxCheckTimeInSeconds     максимальное время проверки в секундах
     * @param millisecondsBetweenChecks интервал между проверками в милисекундах
     */
    private void checkConditionTimeouts(long maxCheckTimeInSeconds, long millisecondsBetweenChecks) {
        Preconditions.checkState(maxCheckTimeInSeconds > 0, "maximum check time in seconds must be not 0");
        Preconditions.checkState(millisecondsBetweenChecks > 0, "milliseconds count between checks must be not 0");
        Preconditions.checkState(millisecondsBetweenChecks < (maxCheckTimeInSeconds * 1000),
                "Millis between checks must be less than max seconds to wait");
    }
}
