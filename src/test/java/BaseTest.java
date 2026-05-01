
import pages.MainPage;
import pages.ForWhomScooterPage;
import pages.AboutRentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected ForWhomScooterPage forWhomScooterPage;
    protected AboutRentPage aboutRentPage;

    @Before
    public void setUp() {
        // Хром
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Либо Firefox (закомментировано)
        // WebDriverManager.firefoxdriver().setup();
        // driver = new FirefoxDriver();

        mainPage = new MainPage(driver);
        forWhomScooterPage = new ForWhomScooterPage(driver);
        aboutRentPage = new AboutRentPage(driver);

        driver.get(TestConfig.SCOOTER_URL);
        driver.manage().window().maximize();
        mainPage.clickCookieButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
