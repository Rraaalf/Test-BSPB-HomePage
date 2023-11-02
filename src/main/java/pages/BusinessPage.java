package pages;

import org.openqa.selenium.WebDriver;

public class BusinessPage {

    private final WebDriver driver;

    public BusinessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
