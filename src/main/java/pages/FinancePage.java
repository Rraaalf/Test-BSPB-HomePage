package pages;

import org.openqa.selenium.WebDriver;

public class FinancePage {

    private final WebDriver driver;

    public FinancePage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
