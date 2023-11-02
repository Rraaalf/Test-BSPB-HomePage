package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginPage {

    private final WebDriver driver;
    public By usernameField = By.xpath("//input[contains(@name, 'username')]");
    public By passwordField = By.xpath("//input[contains(@name, 'password')]");
    public By loginButton = By.xpath("//button[contains(@id, 'login')]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }

    public void closeTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
