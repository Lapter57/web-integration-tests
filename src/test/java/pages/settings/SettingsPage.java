package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

public class SettingsPage extends BasePage {
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

    public PersonalDataPage clickPersonalData() {
        click(PERSONAL_DATA);
        return new PersonalDataPage(driver);
    }

    public PasswordPage clickPassword() {
        click(PASSWORD);
        return new PasswordPage(driver);
    }

    public boolean isErrorsExist() {
        return driver.findElements(ERRORS).size() != 0;
    }
}
