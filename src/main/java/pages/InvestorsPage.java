package pages;

import org.openqa.selenium.WebDriver;

public class InvestorsPage {

    private final WebDriver DRIVER;

    public final String INVESTORS_URL = "https://www.bspb.ru/investors";

    public InvestorsPage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
