package pages;

import org.openqa.selenium.WebDriver;

public class InvestorsPage {

    private final WebDriver driver;

    public InvestorsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
