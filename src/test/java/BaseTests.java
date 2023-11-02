import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {

    protected static WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void goHome(){
        driver.get("https://www.bspb.ru/");
        homePage = new HomePage(driver);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
