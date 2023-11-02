import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderButtonsTest extends BaseTests {

    String retailUrl = "https://www.bspb.ru/retail";
    String businessUrl = "https://www.bspb.ru/business";
    String foreignTradeUrl = "https://www.bspb.ru/foreign-trade";
    String financeUrl = "https://www.bspb.ru/finance";
    String privateBankingUrl = "https://pb.bspb.ru/";
    String investorsUrl = "https://www.bspb.ru/investors";
    String loginUrl = "https://i.bspb.ru/";
    String debitUrl = "https://www.bspb.ru/retail/cards/debit";
    int timerInMillis = 3000;

    @Test
    public void testRetailButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.retailButton), "Retail button doesn't appear");
        RetailPage retailPage = homePage.clickRetail();
        Thread.sleep(timerInMillis);
        assertEquals(retailUrl, retailPage.getUrl());
    }

    @Test
    public void testBusinessButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.businessButton), "Business button doesn't appear");
        BusinessPage businessPage = homePage.clickBusinessPage();
        Thread.sleep(timerInMillis);
        assertEquals(businessUrl, businessPage.getUrl());
    }

    @Test
    public void testForeignTradeButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.foreignTradeButton), "Foreign trade button doesn't appear");
        ForeignTradePage foreignTradePage = homePage.clickForeignTrade();
        Thread.sleep(timerInMillis);
        assertEquals(foreignTradeUrl, foreignTradePage.getUrl());
    }

    @Test
    public void testFinanceButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.financeButton), "Finance button doesn't appear");
        FinancePage financePage = homePage.clickFinancePage();
        Thread.sleep(timerInMillis);
        assertEquals(financeUrl, financePage.getUrl());
    }

    @Test
    public void testPrivateBankingButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.privateBankingButton), "Private banking button doesn't appear");
        PrivateBankingPage privateBankingPage = homePage.clickPrivateBankingPage();
        Thread.sleep(timerInMillis);
        assertEquals(privateBankingUrl, privateBankingPage.getUrl());
    }

    @Test
    public void testInvestorsButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.investorsButton), "Investors button doesn't appear");
        InvestorsPage investorsPage = homePage.clickInvestorsPage();
        Thread.sleep(timerInMillis);
        assertEquals(investorsUrl, investorsPage.getUrl());
    }

    @Test
    public void testLoginButton() throws InterruptedException {
        assertTrue(homePage.isDisplayed(homePage.loginButton), "Login button doesn't appear");
        LoginPage loginPage = homePage.clickLoginPage();
        Thread.sleep(timerInMillis);
        homePage.switchToSecondTab();
        assertTrue(loginPage.getUrl().contains(loginUrl), "URL doesn't contain \"https://i.bspb.ru/\"");
        assertTrue(loginPage.isDisplayed(loginPage.usernameField), "Username field doesn't appear");
        assertTrue(loginPage.isDisplayed(loginPage.passwordField), "Password field doesn't appear");
        assertTrue(loginPage.isDisplayed(loginPage.loginButton), "Login button doesn't appear");
        loginPage.closeTab();
    }

    @Test
    public void testDebitButton() throws InterruptedException {
        RetailPage retailPage = homePage.clickRetail();
        Thread.sleep(timerInMillis);
        DebitPage debitPage = retailPage.clickDebit();
        Thread.sleep(timerInMillis);
        assertEquals(debitUrl, debitPage.getUrl());
    }


}
