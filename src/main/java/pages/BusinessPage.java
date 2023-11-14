package pages;

import org.openqa.selenium.WebDriver;

public class BusinessPage {

    private final WebDriver DRIVER;

    public final String BUSINESS_URL = "https://www.bspb.ru/business";

    public BusinessPage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
