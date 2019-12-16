package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.login.LoginPage;
import pages.feed.UserMainPage;
import pages.settings.SettingsPage;

public class ProfileTest extends TestBase {
    private static final int PASSWORD_SIZE = 10;

    @Test
    public void inabilityChangePersonalDataWithBlankFields() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        final SettingsPage settingsPage = userMainPage.clickMySettingsBtn();
        settingsPage.changePersonalData("", "", "");
        Assert.assertTrue("Personal data was changed", settingsPage.isErrorsExist());
    }

    @Test
    public void inabilityChangePasswordIfCurrentPasswordEnteredIncorrectly() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickMySettingsBtn();
        final SettingsPage settingsPage = new SettingsPage(driver);
        final String currentPassword = generateRandomString(PASSWORD_SIZE);
        final String newPassword = generateRandomString(PASSWORD_SIZE);
        settingsPage.changePassword(currentPassword, newPassword);
        Assert.assertTrue("Password was changed", settingsPage.isErrorsExist());
    }
}
