import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ForWhomScooterPage;

@RunWith(Parameterized.class)
public class OrderTests {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String comment;

    private WebDriver driver;
    private MainPage mainPage;
    private ForWhomScooterPage forWhomScooterPage;


    public static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/"; //Адрес главной страницы "Яндекс Самоката"

    //Конструктор
    public OrderTests(String firstName, String lastName, String address, String phoneNumber, String deliveryDate, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Настя", "Попова", "Сиэтл", "79991112233", "05.07.1999", "With the lights out!"},
                {"Дима", "Алешин", "Вашингтон", "79994445566", "31.12.2022", "Привет, меня зовут Крист!"},
                {"Мария", "Воронина", "Лос-Анджелес", "79998833766", "01.01.2024", "FooFighters"},
        };
    }

    @Before
    public void setUp() {
//хром
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//либо Firefox

         //WebDriverManager.firefoxdriver().setup();
         //driver = new FirefoxDriver();

        mainPage = new MainPage(driver);
        forWhomScooterPage = new ForWhomScooterPage(driver);


        driver.get(SCOOTER_URL);
        driver.manage().window().maximize();  //Расширение экрана
        mainPage.clickCookieButton();
    }

    @Test
    public void testFullOrderByFirstButton() {
        mainPage.clickOrderUpButton(); //Клик на верхнюю кнопку "Заказать" на главной странице

        forWhomScooterPage.fillOrderForm1(firstName, lastName, address, phoneNumber);  //Заполняется форма "Для кого самокат"
        forWhomScooterPage.nextButtonClick(); //Клик на кнопку "Далее"


    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}