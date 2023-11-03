import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderButtonsTests extends BaseTests {

    Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

    SoftAssertions softly = new SoftAssertions();

    final String retailUrl = "https://www.bspb.ru/retail";
    final String businessUrl = "https://www.bspb.ru/business";
    final String foreignTradeUrl = "https://www.bspb.ru/foreign-trade";
    final String financeUrl = "https://www.bspb.ru/finance";
    final String privateBankingUrl = "https://pb.bspb.ru/";
    final String investorsUrl = "https://www.bspb.ru/investors";
    final String loginUrl = "https://i.bspb.ru/";
    final String debitUrl = "https://www.bspb.ru/retail/cards/debit";

    @Test
    public void testRetailButton() {
        assertThat(homePage.isDisplayed(homePage.retailButton))
                .as("Retail button doesn't appear");
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailUrl));
        assertThat(retailPage.getUrl().contains(retailUrl))
                .as("URL doesn't contain %s", retailUrl);
    }

    @Test
    public void testBusinessButton() {
        assertThat(homePage.isDisplayed(homePage.businessButton))
                .as("Business button doesn't appear");
        BusinessPage businessPage = homePage.clickBusinessPage();
        fluentWait.until(ExpectedConditions.urlToBe(businessUrl));
        assertThat(businessPage.getUrl().contains(businessUrl))
                .as("URL doesn't contain %s", businessUrl);
    }

    @Test
    public void testForeignTradeButton() {
        assertThat(homePage.isDisplayed(homePage.foreignTradeButton))
                .as("Foreign trade button doesn't appear");
        ForeignTradePage foreignTradePage = homePage.clickForeignTrade();
        fluentWait.until(ExpectedConditions.urlToBe(foreignTradeUrl));
        assertThat((foreignTradePage.getUrl().contains(foreignTradeUrl)))
                .as("URL doesn't contain %s", foreignTradeUrl);
    }

    @Test
    public void testFinanceButton() {
        assertThat(homePage.isDisplayed(homePage.financeButton))
                .as("Finance button doesn't appear");
        FinancePage financePage = homePage.clickFinancePage();
        fluentWait.until(ExpectedConditions.urlToBe(financeUrl));
        assertThat(financePage.getUrl().contains(financeUrl))
                .as("URL doesn't contain %s", financeUrl);
    }

    @Test
    public void testPrivateBankingButton() {
        assertThat(homePage.isDisplayed(homePage.privateBankingButton))
                .as("Private banking button doesn't appear");
        PrivateBankingPage privateBankingPage = homePage.clickPrivateBankingPage();
        fluentWait.until(ExpectedConditions.urlToBe(privateBankingUrl));
        assertThat(privateBankingPage.getUrl().contains(privateBankingUrl))
                .as("URL doesn't contain %s", privateBankingUrl);
    }

    @Test
    public void testInvestorsButton() {
        assertThat(homePage.isDisplayed(homePage.investorsButton))
                .as("Investors button doesn't appear");
        InvestorsPage investorsPage = homePage.clickInvestorsPage();
        fluentWait.until(ExpectedConditions.urlToBe(investorsUrl));
        assertThat(investorsPage.getUrl().contains(investorsUrl))
                .as("URL doesn't contain %s", investorsUrl);
    }

    @Test
    public void testLoginButton() {
        assertThat(homePage.isDisplayed(homePage.loginButton))
                .as("Login button doesn't appear");
        LoginPage loginPage = homePage.clickLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        homePage.switchToSecondTab();
        softly.assertThat(loginPage.getUrl().contains(loginUrl))
                .as("URL doesn't contain %s", loginUrl);
        softly.assertThat(loginPage.isDisplayed(loginPage.usernameField))
                .as("Username field doesn't appear");
        softly.assertThat(loginPage.isDisplayed(loginPage.passwordField))
                .as("Password field doesn't appear");
        softly.assertThat(loginPage.isDisplayed(loginPage.loginButton))
                .as("Login button doesn't appear");
        softly.assertAll();
        loginPage.closeTab();
    }

    @Test
    public void testDebitButton() {
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailUrl));
        DebitPage debitPage = retailPage.clickDebit();
        fluentWait.until(ExpectedConditions.urlToBe(debitUrl));
        assertThat(debitPage.getUrl().contains(debitUrl))
                .as("URL doesn't contain %s", debitPage);
    }


}
