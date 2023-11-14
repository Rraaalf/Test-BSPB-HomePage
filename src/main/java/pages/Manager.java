package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Manager {

    public final WebDriver DRIVER;

    public Manager(WebDriver driver){
        this.DRIVER = driver;
    }

    public String getUrl() {
        return DRIVER.getCurrentUrl();
    }

    public boolean isDisplayed(By element) {
        return DRIVER.findElement(element).isDisplayed();
    }

    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<>(DRIVER.getWindowHandles());
        DRIVER.switchTo().window(tabs.get(1));
    }

    public void closeTab() {
        ArrayList<String> tabs = new ArrayList<>(DRIVER.getWindowHandles());
        DRIVER.close();
        DRIVER.switchTo().window(tabs.get(0));
    }
}
