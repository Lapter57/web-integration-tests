package pages.login;

import model.Bot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

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

    public void login(final Bot bot) {
        Assert.assertTrue("Login field is not visible", isElementVisible(LOGIN));
        type(LOGIN, bot.getLogin());

        Assert.assertTrue("Password field is not visible", isElementVisible(PASSWORD));
        type(PASSWORD, bot.getPassword());

        Assert.assertTrue("Login button is not visible", isElementVisible(LOGIN_BTN));
        Assert.assertTrue("Login button is disabled", isElementEnabled(LOGIN_BTN));
        click(LOGIN_BTN);
    }
}
