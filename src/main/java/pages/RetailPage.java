package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class RetailPage {

    private final WebDriver driver;
    public By cardsField = By.xpath("//div[@class='css-nxqkh1']/span[contains(., 'Карты')]");
    public By debitButton = By.xpath("//a[@href=\"/retail/cards/debit\"]");

    public RetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public DebitPage clickDebit(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(cardsField)).perform();
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchFieldError.class);
        driver.findElement(debitButton).click();
        return new DebitPage(driver);
    }


}
