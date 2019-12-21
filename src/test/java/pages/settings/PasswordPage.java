package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class PasswordPage extends BasePage {
    private static final By CURRENT_PASSWORD_FIELD = By.id("field_oldPassword");
    private static final By NEW_PASSWORD_FIELD = By.id("field_newPassword");
    private static final By RETYPE_PASSWORD_FIELD = By.id("field_retypePassword");
    private static final By SAVE_NEW_PASSWORD_BTN = By.xpath(".//input[@data-l='t,submit']");

    public PasswordPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(CURRENT_PASSWORD_FIELD, NEW_PASSWORD_FIELD,
                RETYPE_PASSWORD_FIELD, SAVE_NEW_PASSWORD_BTN);
    }

    public PasswordPage typeCurrentPassword(final String password) {
        type(CURRENT_PASSWORD_FIELD, password);
        return new PasswordPage(driver);
    }

    public PasswordPage typeNewPassword(final String password) {
        type(NEW_PASSWORD_FIELD, password);
        return new PasswordPage(driver);
    }

    public PasswordPage retypeNewPassword(final String password) {
        type(RETYPE_PASSWORD_FIELD, password);
        return new PasswordPage(driver);
    }

    public PasswordPage saveNewPassword() {
        click(SAVE_NEW_PASSWORD_BTN);
        return new PasswordPage(driver);
    }
}
