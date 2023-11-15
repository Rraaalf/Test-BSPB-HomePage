package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    protected static WebDriver driver;
    protected BusinessPage businessPage = new BusinessPage(driver);
    protected DebitPage debitPage = new DebitPage(driver);
    protected FinancePage financePage = new FinancePage(driver);
    protected ForeignTradePage foreignTradePage = new ForeignTradePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected InvestorsPage investorsPage = new InvestorsPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected PrivateBankingPage privateBankingPage = new PrivateBankingPage(driver);
    protected RetailPage retailPage = new RetailPage(driver);
    protected SoftAssertions softly = new SoftAssertions();

    protected Map<String, By> buttons = new HashMap<>();

    {
        buttons.put("Частным клиентам", homePage.RETAIL_BUTTON);
        buttons.put("Бизнесу", homePage.BUSINESS_BUTTON);
        buttons.put("ВЭД", homePage.FOREIGN_TRADE_BUTTON);
        buttons.put("Финансовые рынки", homePage.FINANCE_BUTTON);
        buttons.put("Private Banking", homePage.PRIVATE_BANKING_BUTTON);
        buttons.put("Инвесторам", homePage.INVESTORS_BUTTON);
        buttons.put("Войти", homePage.LOGIN_BUTTON);
    }

    protected Map<String, String> urls = new HashMap<>();

    {
        urls.put("Частным клиентам", retailPage.RETAIL_URL);
        urls.put("Бизнесу", businessPage.BUSINESS_URL);
        urls.put("ВЭД", foreignTradePage.FOREIGN_TRADE_URL);
        urls.put("Финансовые рынки", financePage.FINANCE_URL);
        urls.put("Private Banking", privateBankingPage.PRIVATE_BANKING_URL);
        urls.put("Инвесторам", investorsPage.INVESTORS_URL);
        urls.put("Авторизация", loginPage.LOGIN_URL);
    }

    protected static void fluentWait(WebDriver driver, String url) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.urlToBe(url));
    }

    public String captureScreen() {
        String path;
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            path = "src/test/resources/attachments/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshotAllure(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Дано("пользователь находится на главной странице БСПБ")
    public void пользовательНаходитсяНаГлавнойСтраницеБСПБ() {
        driver.get("https://www.bspb.ru/");
    }

//    @И("отображаются кнопки")
//    public void отображаютсяКнопки(List<String> button) {
//        for (String b : button) {
//            softly.assertThat(driver.findElement(buttons.get(b)).isDisplayed())
//                    .as("Проверка отображения кнопки \"%s\"", b)
//                    .isFalse();
////            System.out.println(b);
////            softly.assertThat(driver.findElement(By.partialLinkText(b)))
////                    .as("Проверка отображения кнопки \"%s\"", b)
////                    .isEqualTo(driver.findElement(buttons.get(b)).getText());
//        }
//    }

//    @И("отображается кнопка {string}")
//    public void отображается(String button) {
//        assertThat(driver.findElement(buttons.get(button)).isDisplayed())
//                .as("Проверка отображения кнопки \"%s\"", button)
//                .isTrue();
//    }

    @Когда("пользователь нажимает на кнопку {string}")
    public void пользовательНажимаетНаКнопку(String button) {
        driver.findElement(buttons.get(button)).click();
    }

    @Тогда("открывается страница {string}")
    public void открываетсяСтраница(String url) {
        try {
            Manager manager = new Manager(driver);
            manager.switchToSecondTab();
            assertThat(driver.getCurrentUrl())
                    .as("Проверка, что URL страницы авторизации начинается с \"%s\"", loginPage.LOGIN_URL)
                    .startsWith(loginPage.LOGIN_URL);
        } catch (IndexOutOfBoundsException e) {
            fluentWait(driver, urls.get(url));
            assertThat(driver.getCurrentUrl())
                    .as("Проверка URL страницы \"%s\"", url)
                    .isEqualTo(urls.get(url));
        }
    }

    @Когда("пользователь вводит {string} и {string} и нажимает кнопку авторизации")
    public void пользовательВводитЛогинИПарольИНажимаетКнопкуАвторизации(String Логин, String Пароль) {
        driver.findElement(loginPage.USERNAME_FIELD).clear();
        driver.findElement(loginPage.USERNAME_FIELD).sendKeys(Логин);
        driver.findElement(loginPage.PASSWORD_FIELD).clear();
        driver.findElement(loginPage.PASSWORD_FIELD).sendKeys(Пароль);
        driver.findElement(loginPage.LOGIN_BUTTON).click();
    }

    @Тогда("появляется сообщение о неправильном вводе пароля")
    public void появляетсяСообщениеОНеправильномВводеПароля() {
        Manager manager = new Manager(driver);
        assertThat(manager.isDisplayed(loginPage.ALERT))
                .as("Проверка появления сообщения о неправильном вводе пароля")
                .isTrue();
    }
}
