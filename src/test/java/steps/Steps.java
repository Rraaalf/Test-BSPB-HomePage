package steps;

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
import org.openqa.selenium.support.ui.Wait;
import pages.HomePage;
import pages.RetailPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private static WebDriver driver;
    private HomePage homePage;
    final String retailUrl = "https://www.bspb.ru/retail";

    Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Дано("Пользователь заходит на главную страницу банка")
    public void пользователь_заходит_на_главную_страницу_банка(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.bspb.ru/");
        homePage = new HomePage(driver);
    }

    @И("Видит кнопку \"Частным клиентам\"")
    public void видит_кнопку_частным_клиентам(){
        assertThat(homePage.isDisplayed(homePage.retailButton))
                .as("Проверка отображения кнопки \"Частным клиентам\"")
                .isTrue();
    }

    @Когда("Пользователь нажимает на кнопку \"Частным клиентам\"")
    public void пользователь_нажимает_на_кнопку_частным_клиентам(){
        driver.findElement(homePage.retailButton).click();
    }

    @Тогда("Пользователь попадает на страницу \"Частным клиентам\"")
    public void пользователь_попадает_на_страницу_частным_клиентам(){
        RetailPage retailPage = homePage.clickRetail();
        fluentWait.until(ExpectedConditions.urlToBe(retailUrl));
        assertThat(retailPage.getUrl())
                .as("Проверка URL страницы \"Частным клиентам\"")
                .isEqualTo(retailUrl);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
