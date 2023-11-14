package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver DRIVER;
    public final By USERNAME_FIELD = By.xpath("//input[contains(@name, 'username')]");
    public final By PASSWORD_FIELD = By.xpath("//input[contains(@name, 'password')]");
    public final By LOGIN_BUTTON = By.xpath("//button[contains(@id, 'login')]");
    public final By ALERT = By.xpath("//div[contains(@class, 'alert')]");
    public final String LOGIN_URL = "https://i.bspb.ru/";

    public LoginPage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
