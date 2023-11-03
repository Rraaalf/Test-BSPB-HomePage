package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class HomePage {

    private final WebDriver driver;
    public final By retailButton = By.xpath("//a[@href='/retail']");
    public final By foreignTradeButton = By.xpath("//a[@href='/foreign-trade']");
    public final By businessButton = By.xpath("//a[@href='/business']");
    public final By financeButton = By.xpath("//a[@href='/finance']");
    public final By privateBankingButton = By.xpath("//a[@href='https://pb.bspb.ru/']");
    public final By investorsButton = By.xpath("//a[@href='/investors']");
    public final By loginButton = By.xpath("//a[@href='https://i.bspb.ru']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }

    public RetailPage clickRetail(){
        driver.findElement(retailButton).click();
        return new RetailPage(driver);
    }

    public ForeignTradePage clickForeignTrade(){
        driver.findElement(foreignTradeButton).click();
        return new ForeignTradePage(driver);
    }

    public BusinessPage clickBusinessPage(){
        driver.findElement(businessButton).click();
        return new BusinessPage(driver);
    }

    public FinancePage clickFinancePage(){
        driver.findElement(financeButton).click();
        return new FinancePage(driver);
    }

    public PrivateBankingPage clickPrivateBankingPage(){
        driver.findElement(privateBankingButton).click();
        return new PrivateBankingPage(driver);
    }

    public InvestorsPage clickInvestorsPage(){
        driver.findElement(investorsButton).click();
        return new InvestorsPage(driver);
    }

    public LoginPage clickLoginPage(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void switchToSecondTab(){
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
    }

}
