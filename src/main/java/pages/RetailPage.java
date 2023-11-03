package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RetailPage {

    private final WebDriver driver;

    public final By cardsField = By.xpath("//div[@class='css-nxqkh1']/span[contains(., 'Карты')]");
    public final By debitButton = By.xpath("//a[@href='/retail/cards/debit']");

    public RetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public DebitPage clickDebit() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(cardsField)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(debitButton).click();
        return new DebitPage(driver);
    }


}
