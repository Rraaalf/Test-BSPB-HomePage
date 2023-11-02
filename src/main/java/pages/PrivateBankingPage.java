package pages;

import org.openqa.selenium.WebDriver;

public class PrivateBankingPage {

    private final WebDriver driver;

    public PrivateBankingPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
