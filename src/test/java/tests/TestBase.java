package tests;

import model.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ThreadLocalRandom;

public class TestBase {
    private static final String BASE_URL = "https://ok.ru";
    private static final String USERNAME_PREFIX = "user";

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
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

    private int randomId() {
        return ThreadLocalRandom.current().nextInt(0, 100);
    }
}
