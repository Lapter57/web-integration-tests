package tests;

import model.Bot;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void login() {
        final Bot bot = generateBot();
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.login(bot);
    }
}
