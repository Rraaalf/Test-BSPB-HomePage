package pages;

import org.openqa.selenium.WebDriver;

public class FinancePage {

    private final WebDriver DRIVER;

    public final String FINANCE_URL = "https://www.bspb.ru/finance";

    public FinancePage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
