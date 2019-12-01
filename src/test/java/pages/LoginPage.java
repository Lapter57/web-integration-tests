package pages;

import model.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPage extends BasePage {
    private static final By LOGIN = By.id("field_email");;
    private static final By PASSWORD = By.id("field_password");
    private static final By LOGIN_BTN = By.xpath(".//*[@class='button-pro __wide']");

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<By> elementsToWait() {
        return List.of(LOGIN, PASSWORD, LOGIN_BTN);
    }

    public void login(final Bot bot) {
        type(LOGIN, bot.getLogin());
        type(PASSWORD, bot.getPassword());
        click(LOGIN_BTN);
    }
}
