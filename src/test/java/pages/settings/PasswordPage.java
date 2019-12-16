package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class PasswordPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(PasswordPage.class);

    private static final By CURRENT_PASSWORD_FIELD = By.id("field_oldPassword");
    private static final By NEW_PASSWORD_FIELD = By.id("field_newPassword");
    private static final By RETYPE_PASSWORD_FIELD = By.id("field_retypePassword");
    private static final By SAVE_NEW_PASSWORD_BTN = By.xpath(".//input[@data-l='t,submit']");

    PasswordPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(CURRENT_PASSWORD_FIELD, NEW_PASSWORD_FIELD,
                RETYPE_PASSWORD_FIELD, SAVE_NEW_PASSWORD_BTN);
    }

    PasswordPage typeCurrentPassword(final String password) {
        type(CURRENT_PASSWORD_FIELD, password);
        log.debug("Typed a current password \"{}\"", password);
        return new PasswordPage(driver);
    }

    PasswordPage typeNewPassword(final String password) {
        type(NEW_PASSWORD_FIELD, password);
        log.debug("Typed a new password \"{}\"", password);
        return new PasswordPage(driver);
    }

    PasswordPage retypeNewPassword(final String password) {
        type(RETYPE_PASSWORD_FIELD, password);
        log.debug("Retyped a new password \"{}\"", password);
        return new PasswordPage(driver);
    }

    PasswordPage saveNewPassword() {
        click(SAVE_NEW_PASSWORD_BTN);
        log.debug("Clicked to save a new password");
        return new PasswordPage(driver);
    }
}
