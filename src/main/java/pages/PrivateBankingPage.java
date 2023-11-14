package pages;

import org.openqa.selenium.WebDriver;

public class PrivateBankingPage {

    private final WebDriver DRIVER;

    public final String PRIVATE_BANKING_URL = "https://pb.bspb.ru/";

    public PrivateBankingPage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
