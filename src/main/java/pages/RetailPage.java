package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RetailPage {

    private final WebDriver DRIVER;

    public final By CARDS_FIELD = By.xpath("//div[@class='css-nxqkh1']/span[contains(., 'Карты')]");
    public final By DEBIT_BUTTON = By.xpath("//a[@href='/retail/cards/debit']");
    public final String RETAIL_URL = "https://www.bspb.ru/retail";

    public RetailPage(WebDriver driver) {
        this.DRIVER = driver;
    }

    public DebitPage clickDebit() {
        Actions actions = new Actions(DRIVER);
        actions.moveToElement(DRIVER.findElement(CARDS_FIELD)).perform();
        DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DRIVER.findElement(DEBIT_BUTTON).click();
        return new DebitPage(DRIVER);
    }
}
