package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver DRIVER;
    public final By RETAIL_BUTTON = By.xpath("//a[@href='/retail']");
    public final By FOREIGN_TRADE_BUTTON = By.xpath("//a[@href='/foreign-trade']");
    public final By BUSINESS_BUTTON = By.xpath("//a[@href='/business']");
    public final By FINANCE_BUTTON = By.xpath("//a[@href='/finance']");
    public final By PRIVATE_BANKING_BUTTON = By.xpath("//a[@href='https://pb.bspb.ru/']");
    public final By INVESTORS_BUTTON = By.xpath("//a[@href='/investors']");
    public final By LOGIN_BUTTON = By.xpath("//a[@href='https://i.bspb.ru']");

    public HomePage(WebDriver driver) {
        this.DRIVER = driver;
    }

    public RetailPage clickRetail() {
        DRIVER.findElement(RETAIL_BUTTON).click();
        return new RetailPage(DRIVER);
    }

    public ForeignTradePage clickForeignTrade() {
        DRIVER.findElement(FOREIGN_TRADE_BUTTON).click();
        return new ForeignTradePage(DRIVER);
    }

    public BusinessPage clickBusinessPage() {
        DRIVER.findElement(BUSINESS_BUTTON).click();
        return new BusinessPage(DRIVER);
    }

    public FinancePage clickFinancePage() {
        DRIVER.findElement(FINANCE_BUTTON).click();
        return new FinancePage(DRIVER);
    }

    public PrivateBankingPage clickPrivateBankingPage() {
        DRIVER.findElement(PRIVATE_BANKING_BUTTON).click();
        return new PrivateBankingPage(DRIVER);
    }

    public InvestorsPage clickInvestorsPage() {
        DRIVER.findElement(INVESTORS_BUTTON).click();
        return new InvestorsPage(DRIVER);
    }

    public LoginPage clickLoginPage() {
        DRIVER.findElement(LOGIN_BUTTON).click();
        return new LoginPage(DRIVER);
    }
}
