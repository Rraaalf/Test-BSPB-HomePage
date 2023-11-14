package pages;

import org.openqa.selenium.WebDriver;

public class ForeignTradePage {

    private final WebDriver DRIVER;

    public final String FOREIGN_TRADE_URL = "https://www.bspb.ru/foreign-trade";

    public ForeignTradePage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
