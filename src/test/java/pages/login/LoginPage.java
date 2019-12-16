package pages.login;

import model.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private static final By LOGIN = By.xpath(".//input[@data-l='t,login']");;
    private static final By PASSWORD = By.xpath(".//input[@data-l='t,password']");
    private static final By LOGIN_BTN = By.xpath(".//*[@type='submit' and @data-l='t,sign_in']");

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(LOGIN, PASSWORD, LOGIN_BTN);
    }

    public void login(final Bot bot) {
        type(LOGIN, bot.getLogin());
        log.debug("Typed the login \"{}\"", bot.getLogin());
        type(PASSWORD, bot.getPassword());
        log.debug("Typed the password \"{}\"", bot.getPassword());
        click(LOGIN_BTN);
        log.debug("Clicked to login in \"{}\"", bot.getPassword());
    }
}
