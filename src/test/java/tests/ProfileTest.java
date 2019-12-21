package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.feed.UserMainPage;
import pages.login.LoginPage;
import pages.settings.SettingsPage;

public class ProfileTest extends TestBase {
    private static final int PASSWORD_SIZE = 10;

    @Test
    public void inabilityChangePersonalDataWithBlankFields() {
        final UserMainPage userMainPage = new LoginPage(driver).login(getTechnoBot());
        final SettingsPage settingsPage = userMainPage.clickMySettingsBtn();
        settingsPage.clickPersonalData()
                .typeName("")
                .typeSurname("")
                .typeLocation("")
                .changePersonalData();
        Assert.assertTrue("Personal data was changed", settingsPage.isErrorsExist());
    }

    @Test
    public void inabilityChangePasswordIfCurrentPasswordEnteredIncorrectly() {
        final UserMainPage userMainPage = new LoginPage(driver).login(getTechnoBot());
        final SettingsPage settingsPage = userMainPage.clickMySettingsBtn();;
        final String currentPassword = generateRandomString(PASSWORD_SIZE);
        final String newPassword = generateRandomString(PASSWORD_SIZE);
        settingsPage.clickPassword()
                .typeCurrentPassword(currentPassword)
                .typeNewPassword(newPassword)
                .retypeNewPassword(newPassword)
                .saveNewPassword();
        Assert.assertTrue("Password was changed", settingsPage.isErrorsExist());
    }
}
