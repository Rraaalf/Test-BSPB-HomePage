package pages;

import org.openqa.selenium.WebDriver;

public class DebitPage {

    private final WebDriver driver;

    public DebitPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
