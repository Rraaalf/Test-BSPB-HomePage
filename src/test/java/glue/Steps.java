package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.HomePage;
import pages.LoginPage;
import pages.Manager;
import pages.RetailPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    protected static WebDriver driver;
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected RetailPage retailPage = new RetailPage(driver);

    protected static void fluentWait(WebDriver driver, String url) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.urlToBe(url));
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

    @И("отображается кнопка {string}")
    public void отображаетсяКнопка(String arg0) {
        if (arg0.contains("Частным клиентам")) {
            assertThat(driver.findElement(homePage.RETAIL_BUTTON).isDisplayed())
                    .as("Проверка отображения кнопки {string}")
                    .isTrue();
        }
        if (arg0.contains("Войти")) {
            assertThat(driver.findElement(homePage.LOGIN_BUTTON).isDisplayed())
                    .as("Проверка отображения кнопки {string}")
                    .isTrue();
        }
    }

    @Когда("пользователь нажимает на кнопку {string}")
    public void пользовательНажимаетНаКнопку(String arg0) {
        if (arg0.contains("Частным клиентам")) {
            driver.findElement(homePage.RETAIL_BUTTON).click();
        }
        if (arg0.contains("Войти")) {
            driver.findElement(homePage.LOGIN_BUTTON).click();
        }
    }

    @Тогда("открывается страница {string}")
    public void открываетсяСтраница(String arg0) {
        if (arg0.contains("Частным клиентам")) {
            driver.findElement(homePage.RETAIL_BUTTON).click();
            fluentWait(driver, retailPage.RETAIL_URL);
            assertThat(driver.getCurrentUrl())
                    .as("Проверка URL страницы \"Частным клиентам\"")
                    .isEqualTo(retailPage.RETAIL_URL);
        }
        if (arg0.contains("Авторизация")) {
            Manager manager = new Manager(driver);
            manager.switchToSecondTab();
            assertThat(driver.getCurrentUrl())
                    .as("Проверка, что URL страницы авторизации начинается с \"%s\"", loginPage.LOGIN_URL)
                    .startsWith(loginPage.LOGIN_URL);
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
