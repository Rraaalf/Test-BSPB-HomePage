package pages;

import org.openqa.selenium.WebDriver;

public class ForeignTradePage {

    private final WebDriver driver;


    public ForeignTradePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
