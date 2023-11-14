package pages;

import org.openqa.selenium.WebDriver;

public class DebitPage {

    private final WebDriver DRIVER;

    public final String DEBIT_URL = "https://www.bspb.ru/retail/cards/debit";

    public DebitPage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
