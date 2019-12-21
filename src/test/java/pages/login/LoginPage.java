package pages.login;

import model.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.feed.UserMainPage;

import java.util.List;

public class LoginPage extends BasePage {
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

    public UserMainPage login(final Bot bot) {
        type(LOGIN, bot.getLogin());
        type(PASSWORD, bot.getPassword());
        click(LOGIN_BTN);
        return new UserMainPage(driver);
    }
}
