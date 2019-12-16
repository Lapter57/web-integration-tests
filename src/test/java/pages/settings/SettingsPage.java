package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class SettingsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SettingsPage.class);

    private static final By PERSONAL_DATA =
            By.xpath(".//*[@class='user-settings __profile']//a[contains(@href, 'cmd=PopLayerEditUserProfileNew')]");
    private static final By PASSWORD =
            By.xpath(".//*[@class='user-settings __profile']//a[contains(@href, 'cmd=PopLayerConfigUserPassword')]");
    private static final By ERRORS = By.xpath(".//span[@class='input-e' and string-length(text()) > 0]");

    public SettingsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(PERSONAL_DATA, PASSWORD);
    }

    public SettingsPage changePersonalData(final String name,
                                           final String surname,
                                           final String location) {
        final PersonalDataPage personalDataPage = clickPersonalData();
        personalDataPage.typeName(name)
                .typeSurname(surname)
                .typeLocation(location)
                .changePersonalData();
        return new SettingsPage(driver);
    }

    public SettingsPage changePassword(final String currentPassword,
                                       final String newPassword) {
        final PasswordPage passwordPage = clickPassword();
        passwordPage.typeCurrentPassword(currentPassword)
                .typeNewPassword(newPassword)
                .retypeNewPassword(newPassword)
                .saveNewPassword();
        return new SettingsPage(driver);
    }

    private PersonalDataPage clickPersonalData() {
        click(PERSONAL_DATA);
        log.debug("Clicked to open a form to edit a personal data");
        return new PersonalDataPage(driver);
    }

    private PasswordPage clickPassword() {
        click(PASSWORD);
        log.debug("Clicked to open a form to edit a password");
        return new PasswordPage(driver);
    }

    public boolean isErrorsExist() {
        return driver.findElements(ERRORS).size() != 0;
    }
}
