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
                .as("Проверка отображения кнопки \"Частным клиентам\"")
                .isTrue();
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailUrl));
        assertThat(retailPage.getUrl())
                .as("Проверка URL страницы \"Частным клиентам\"")
                .isEqualTo(retailUrl);
    }

    @Test
    public void testBusinessButton() {
        assertThat(homePage.isDisplayed(homePage.businessButton))
                .as("Проверка отображения кнопки \"Бизнесу\"")
                .isTrue();
        BusinessPage businessPage = homePage.clickBusinessPage();
        fluentWait.until(ExpectedConditions.urlToBe(businessUrl));
        assertThat(businessPage.getUrl())
                .as("Проверка URL страницы \"Бизнесу\"")
                .isEqualTo(businessUrl);
    }


    @Test
    public void testForeignTradeButton() {
        assertThat(homePage.isDisplayed(homePage.foreignTradeButton))
                .as("Проверка отображения кнопки \"ВЭД\"")
                .isTrue();
        ForeignTradePage foreignTradePage = homePage.clickForeignTrade();
        fluentWait.until(ExpectedConditions.urlToBe(foreignTradeUrl));
        assertThat(foreignTradePage.getUrl())
                .as("Проверка URL страницы \"ВЭД\"")
                .isEqualTo(foreignTradeUrl);
    }

    @Test
    public void testFinanceButton() {
        assertThat(homePage.isDisplayed(homePage.financeButton))
                .as("Проверка отображения кнопки \"Финансовые рынки\"")
                .isTrue();
        FinancePage financePage = homePage.clickFinancePage();
        fluentWait.until(ExpectedConditions.urlToBe(financeUrl));
        assertThat(financePage.getUrl())
                .as("Проверка URL страницы \"Финансовые рынки\"")
                .isEqualTo(financeUrl);
    }

    @Test
    public void testPrivateBankingButton() {
        assertThat(homePage.isDisplayed(homePage.privateBankingButton))
                .as("Проверка отображения кнопки \"Private Banking\"")
                .isTrue();
        PrivateBankingPage privateBankingPage = homePage.clickPrivateBankingPage();
        fluentWait.until(ExpectedConditions.urlToBe(privateBankingUrl));
        assertThat(privateBankingPage.getUrl())
                .as("Проверка URL страницы \"Private Banking\"").
                isEqualTo(privateBankingUrl);
    }

    @Test
    public void testInvestorsButton() {
        assertThat(homePage.isDisplayed(homePage.investorsButton))
                .as("Проверка отображения кнопки \"Инвесторам\"")
                .isTrue();
        InvestorsPage investorsPage = homePage.clickInvestorsPage();
        fluentWait.until(ExpectedConditions.urlToBe(investorsUrl));
        assertThat(investorsPage.getUrl())
                .as("Проверка URL страницы \"Инвесторам\"")
                .isEqualTo(investorsUrl);
    }

    @Test
    public void testLoginButton() {
        assertThat(homePage.isDisplayed(homePage.loginButton))
                .as("Проверка отображения кнопки \"Войти\"")
                .isTrue();
        LoginPage loginPage = homePage.clickLoginPage();
        homePage.switchToSecondTab();
        softly.assertThat(loginPage.getUrl())
                .as("Проверка, что URL страницы авторизации начинается с \"%s\"", loginUrl)
                .startsWith(loginUrl);
        softly.assertThat(loginPage.isDisplayed(loginPage.usernameField))
                .as("Проверка отображения поля ввода логина")
                .isTrue();
        softly.assertThat(loginPage.isDisplayed(loginPage.passwordField))
                .as("Проверка отображения поля ввода пароля")
                .isTrue();
        softly.assertThat(loginPage.isDisplayed(loginPage.loginButton))
                .as("Проверка отображения кнопки авторизации")
                .isTrue();
        softly.assertAll();
        loginPage.closeTab();
    }

    @Test
    public void testDebitButton() {
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailUrl));
        DebitPage debitPage = retailPage.clickDebit();
        fluentWait.until(ExpectedConditions.urlToBe(debitUrl));
        assertThat(debitPage.getUrl())
                .as("Проверка URL страницы \"Дебетовые карты\"")
                .isEqualTo(debitUrl);
    }
}
