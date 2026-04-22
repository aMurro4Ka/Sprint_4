import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ForWhomScooterPage;

public class SecondOrderButtonTest {
    private WebDriver driver;
    private MainPage mainPage;
    private ForWhomScooterPage forWhomScooterPage;
    public static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/"; //Адрес главной страницы "Яндекс Самоката"

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); // Хром

        // Firefox
        // WebDriverManager.firefoxdriver().setup();
        // driver = new FirefoxDriver();

        mainPage = new MainPage(driver);
        forWhomScooterPage = new ForWhomScooterPage(driver);

        driver.get(SCOOTER_URL);
        driver.manage().window().maximize();
        mainPage.clickCookieButton();
    }

    @Test
    public void SecondOrderButton() {
        mainPage.scrollToOrderDownButtonAndClick(); //Скролл и клик на нижнюю кнопку "Заказать" на главной странице
        forWhomScooterPage.assertOrderDoneTextVisible(); //Проверяется наличие текста "Для кого самокат"
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер
        }
    }
}