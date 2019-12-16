package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class PersonalDataPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(PersonalDataPage.class);

    private static final By NAME_FIELD = By.xpath(".//*[@data-l='t,name']//input");
    private static final By SURNAME_FIELD = By.xpath(".//*[@data-l='t,surname']//input");
    private static final By LOCATION_FIELD = By.xpath(".//*[@data-module='locations']//input");
    private static final By EDIT_PERSONAL_DATA_BTN = By.xpath(".//input[@data-l='t,confirm']");

    PersonalDataPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(NAME_FIELD, SURNAME_FIELD, LOCATION_FIELD, EDIT_PERSONAL_DATA_BTN);
    }

    PersonalDataPage changePersonalData() {
        click(EDIT_PERSONAL_DATA_BTN);
        log.debug("Clicked to edit a personal data");
        return new PersonalDataPage(driver);
    }

    PersonalDataPage typeName(final String name) {
        type(NAME_FIELD, name);
        log.debug("Typed a name \"{}\"", name);
        return new PersonalDataPage(driver);
    }

    PersonalDataPage typeSurname(final String surname) {
        type(SURNAME_FIELD, surname);
        log.debug("Typed a surname \"{}\"", surname);
        return new PersonalDataPage(driver);
    }

    PersonalDataPage typeLocation(final String location) {
        type(LOCATION_FIELD, location);
        log.debug("Typed a location \"{}\"", location);
        return new PersonalDataPage(driver);
    }
}
