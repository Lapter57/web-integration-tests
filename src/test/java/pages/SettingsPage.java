package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SettingsPage extends BasePage {
    private static final By PERSONAL_DATA =
            By.xpath(".//*[@class='user-settings __profile']//a[contains(@href, 'cmd=PopLayerEditUserProfileNew')]");
    private static final By NAME_FIELD = By.xpath(".//*[@data-l='t,name']//input");
    private static final By SURNAME_FIELD = By.xpath(".//*[@data-l='t,surname']//input");
    private static final By LOCATION_FIELD = By.xpath(".//*[@data-module='locations']//input");
    private static final By EDIT_PERSONAL_DATA_BTN = By.xpath(".//input[@data-l='t,confirm']");

    private static final By PASSWORD =
            By.xpath(".//*[@class='user-settings __profile']//a[contains(@href, 'cmd=PopLayerConfigUserPassword')]");
    private static final By CURRENT_PASSWORD_FIELD = By.id("field_oldPassword");
    private static final By NEW_PASSWORD_FIELD = By.id("field_newPassword");
    private static final By RETYPE_PASSWORD_FIELD = By.id("field_retypePassword");
    private static final By SAVE_NEW_PASSWORD_BTN = By.xpath(".//input[@data-l='t,submit']");

    private static final By ERRORS = By.xpath(".//span[@class='input-e' and string-length(text()) > 0]");

    public SettingsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(PERSONAL_DATA, PASSWORD);
    }

    public void clickPersonalData() {
        Assert.assertTrue("Personal data is not visible", isElementVisible(PERSONAL_DATA));
        explicitWait(ExpectedConditions.elementToBeClickable(PERSONAL_DATA), 10, 500);
        click(PERSONAL_DATA);
    }

    public void clickPassword() {
        Assert.assertTrue("Field of password is not visible", isElementVisible(PASSWORD));
        explicitWait(ExpectedConditions.elementToBeClickable(PASSWORD), 10, 500);
        click(PASSWORD);
    }

    public void typeName(final String name) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(NAME_FIELD), 10, 500);
        Assert.assertTrue("Field of name is not visible", isElementVisible(NAME_FIELD));
        type(NAME_FIELD, name);
    }

    public void typeSurname(final String surname) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SURNAME_FIELD), 10, 500);
        Assert.assertTrue("Field of surname is not visible", isElementVisible(SURNAME_FIELD));
        type(SURNAME_FIELD, surname);
    }

    public void typeLocation(final String location) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(LOCATION_FIELD), 10, 500);
        Assert.assertTrue("Field of location is not visible", isElementVisible(LOCATION_FIELD));
        type(LOCATION_FIELD, location);
    }

    public void changePersonalData() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(EDIT_PERSONAL_DATA_BTN), 10, 500);
        Assert.assertTrue("Personal data edit button is not visible", isElementVisible(EDIT_PERSONAL_DATA_BTN));
        click(EDIT_PERSONAL_DATA_BTN);
    }

    public void typeCurrentPassword(final String password) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(CURRENT_PASSWORD_FIELD), 10, 500);
        Assert.assertTrue("Field of current password is not visible", isElementVisible(CURRENT_PASSWORD_FIELD));
        type(CURRENT_PASSWORD_FIELD, password);
    }

    public void typeNewPassword(final String password) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(NEW_PASSWORD_FIELD), 10, 500);
        Assert.assertTrue("Field of new password is not visible", isElementVisible(NEW_PASSWORD_FIELD));
        type(NEW_PASSWORD_FIELD, password);
    }

    public void retypeNewPassword(final String password) {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(RETYPE_PASSWORD_FIELD), 10, 500);
        Assert.assertTrue("Field of retype new password is not visible", isElementVisible(RETYPE_PASSWORD_FIELD));
        type(RETYPE_PASSWORD_FIELD, password);
    }

    public void saveNewPassword() {
        explicitWait(ExpectedConditions.visibilityOfElementLocated(SAVE_NEW_PASSWORD_BTN), 10, 500);
        Assert.assertTrue("Save new password button is not visible", isElementVisible(SAVE_NEW_PASSWORD_BTN));
        click(SAVE_NEW_PASSWORD_BTN);
    }

    public boolean isErrorsExist() {
        return driver.findElements(ERRORS).size() != 0;
    }
}
