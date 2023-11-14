import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Проверка работоспособности кнопок на главной странице сайта БСПБ")
@DisplayName("Кнопки в верхней части страницы")
public class HeaderButtonsTests extends BaseTests {

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Частным клиентам\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testRetailButton() {
        assertThat(manager.isDisplayed(homePage.RETAIL_BUTTON))
                .as("Проверка отображения кнопки \"Частным клиентам\"")
                .isTrue();
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailPage.RETAIL_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Частным клиентам\"")
                .isEqualTo(retailPage.RETAIL_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Бизнесу\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testBusinessButton() {
        assertThat(manager.isDisplayed(homePage.BUSINESS_BUTTON))
                .as("Проверка отображения кнопки \"Бизнесу\"")
                .isTrue();
        BusinessPage businessPage = homePage.clickBusinessPage();
        fluentWait.until(ExpectedConditions.urlToBe(businessPage.BUSINESS_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Бизнесу\"")
                .isEqualTo(businessPage.BUSINESS_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"ВЭД\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testForeignTradeButton() {
        assertThat(manager.isDisplayed(homePage.FOREIGN_TRADE_BUTTON))
                .as("Проверка отображения кнопки \"ВЭД\"")
                .isTrue();
        ForeignTradePage foreignTradePage = homePage.clickForeignTrade();
        fluentWait.until(ExpectedConditions.urlToBe(foreignTradePage.FOREIGN_TRADE_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"ВЭД\"")
                .isEqualTo(foreignTradePage.FOREIGN_TRADE_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Финансовые рынки\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testFinanceButton() {
        assertThat(manager.isDisplayed(homePage.FINANCE_BUTTON))
                .as("Проверка отображения кнопки \"Финансовые рынки\"")
                .isTrue();
        FinancePage financePage = homePage.clickFinancePage();
        fluentWait.until(ExpectedConditions.urlToBe(financePage.FINANCE_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Финансовые рынки\"")
                .isEqualTo(financePage.FINANCE_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Private Banking\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testPrivateBankingButton() {
        assertThat(manager.isDisplayed(homePage.PRIVATE_BANKING_BUTTON))
                .as("Проверка отображения кнопки \"Private Banking\"")
                .isTrue();
        PrivateBankingPage privateBankingPage = homePage.clickPrivateBankingPage();
        fluentWait.until(ExpectedConditions.urlToBe(privateBankingPage.PRIVATE_BANKING_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Private Banking\"").
                isEqualTo(privateBankingPage.PRIVATE_BANKING_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Инвесторам\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testInvestorsButton() {
        assertThat(manager.isDisplayed(homePage.INVESTORS_BUTTON))
                .as("Проверка отображения кнопки \"Инвесторам\"")
                .isTrue();
        InvestorsPage investorsPage = homePage.clickInvestorsPage();
        fluentWait.until(ExpectedConditions.urlToBe(investorsPage.INVESTORS_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Инвесторам\"")
                .isEqualTo(investorsPage.INVESTORS_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Войти\"")
    @Description("Проверка отображения и открытия страницы по нажатию, а также отображение на открытой странице полей ввода логина и пароля, кнопки авторизации")
    @Flaky
    @Test
    public void testLoginButton() {
        assertThat(manager.isDisplayed(homePage.LOGIN_BUTTON))
                .as("Проверка отображения кнопки \"Войти\"")
                .isTrue();
        LoginPage loginPage = homePage.clickLoginPage();
        manager.switchToSecondTab();
        softly.assertThat(manager.getUrl())
                .as("Проверка, что URL страницы авторизации начинается с \"%s\"", loginPage.LOGIN_URL)
                .startsWith(loginPage.LOGIN_URL);
        softly.assertThat(manager.isDisplayed(loginPage.USERNAME_FIELD))
                .as("Проверка отображения поля ввода логина")
                .isTrue();
        softly.assertThat(manager.isDisplayed(loginPage.PASSWORD_FIELD))
                .as("Проверка отображения поля ввода пароля")
                .isTrue();
        softly.assertThat(manager.isDisplayed(loginPage.LOGIN_BUTTON))
                .as("Проверка отображения кнопки авторизации")
                .isTrue();
        softly.assertAll();
        manager.closeTab();
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Кнопка \"Дебетовые карты\" во всплывающем окне \"Карты\"")
    @Description("Проверка отображения и открытия страницы по нажатию")
    @Test
    public void testDebitButton() {
        homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailPage.RETAIL_URL));
        DebitPage debitPage = retailPage.clickDebit();
        fluentWait.until(ExpectedConditions.urlToBe(debitPage.DEBIT_URL));
        assertThat(manager.getUrl())
                .as("Проверка URL страницы \"Дебетовые карты\"")
                .isEqualTo(debitPage.DEBIT_URL);
    }

    @Owner(value = "Илья Никулин")
    @DisplayName("Форма авторизации")
    @Description("Проверка ввода некорректных данных в форму авторизации")
    @ParameterizedTest(name = "Логин:{0}; пароль:{1}")
    @CsvSource({
            "admin, admin",
            "login, password"
    })
    public void testAuthorisationFields(String login, String password) {
        homePage.clickLoginPage();
        manager.switchToSecondTab();
        driver.findElement(loginPage.USERNAME_FIELD).clear();
        driver.findElement(loginPage.USERNAME_FIELD).sendKeys(login);
        driver.findElement(loginPage.PASSWORD_FIELD).clear();
        driver.findElement(loginPage.PASSWORD_FIELD).sendKeys(password);
        driver.findElement(loginPage.LOGIN_BUTTON).click();
        assertThat(manager.isDisplayed(loginPage.ALERT))
                .as("Проверка появления сообщения о неправильном вводе пароля")
                .isTrue();
        manager.closeTab();
    }
}
