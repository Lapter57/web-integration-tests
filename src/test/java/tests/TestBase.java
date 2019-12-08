package tests;

import model.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private static final String BASE_URL = "https://ok.ru";
    private static final String USERNAME_PREFIX = "user";
    private static final String LOGIN_BOT = "TechoBot5";
    private static final String PASSWORD_BOT = "TechnoPolis19";
    private static final Bot TECHNO_BOT = new Bot(LOGIN_BOT, PASSWORD_BOT);

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    public Bot generateBot() {
        final String username = USERNAME_PREFIX + randomId();
        final String password = RandomStringUtils.randomAlphanumeric(8);
        return new Bot(username, password);
    }

    public Bot getTechnoBot() {
        return TECHNO_BOT;
    }

    private int randomId() {
        return ThreadLocalRandom.current().nextInt(0, 100);
    }

    public static String generateRandomString(final int size) {
        return RandomStringUtils.randomAlphabetic(size);
    }
}
