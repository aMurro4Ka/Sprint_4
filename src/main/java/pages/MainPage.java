package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс главной страницы Яндекс Самоката
public class MainPage {
private WebDriver driver;
    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By mainScooterPage = By.xpath("//*[contains(@href,'https://qa-scooter.praktikum-services.ru/')]");

    private By orderUpButton = By.xpath("//button[@class='Button_Button__ra12g' and text()='Заказать']"); //Локатор верхней кнопки "Заказать"
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();   // Клик на верхнюю кнопку "Заказать"
    }
    private By orderDownButton = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp' or (@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    //Локатор нижней кнопки "Заказать"

    //Скролл и клик на нижнюю кнопку "Заказать"
    public void scrollToOrderDownButtonAndClick() {
        WebElement element = driver.findElement(orderDownButton);
        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Ожидание
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(orderDownButton));
        // Клик по кнопке
        element.click();
    }
    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();   // Клик на нижнюю кнопку "Заказать"
    }

    private By cookieButton = By.id("rcc-confirm-button"); // Локатор кнопки "да все привыкли" у куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();   // Клик на куки
    }



    //Локаторы кнопок списка:
    private By howMuchDoesItCostButton = By.id("accordion__heading-0"); //  "Сколько это стоит? И как оплатить"
    private By iWantToSeveralScootersButton = By.id("accordion__heading-1"); //  "Хочу сразу несколько самокатов! Так можно?"
    private By howIsRentalTimeCalculatedButton = By.id("accordion__heading-2"); //  "Как рассчитывается время аренды?"
    private By isItPossibleToOrderScooterTodayButton = By.id("accordion__heading-3"); //  "Можно ли заказать самокат прямо на сегодня?"
    private By isItPossibleToExtendOrderButton = By.id("accordion__heading-4"); //  "Можно ли продлить заказ или вернуть самокат раньше?"
    private By doYouBringChargerButton = By.id("accordion__heading-5"); // "Вы привозите зарядку вместе с самокатом?"
    private By isItPossibleToCancelOrderButton = By.id("accordion__heading-6"); // "Можно ли отменить заказ?"
    private By iLiveOutsideButton = By.id("accordion__heading-7"); //  "Я живу за МКАДом, привезёте?"


    private By howMuchDoesItCostText = By.xpath("//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]");
    private By iWantToSeveralScootersText = By.xpath("//p[contains(text(),'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]");
    private By howIsRentalTimeCalculatedText = By.xpath("//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]");
    private By isItPossibleToOrderScooterTodayText = By.xpath("//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]");
    private By isItPossibleToExtendOrderText = By.xpath("//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.')]");
    private By doYouBringChargerText = By.xpath("//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.')]");
    private By isItPossibleToCancelOrderText = By.xpath("//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.')]");
    private By iLiveOutsideText = By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]");




    private String closedDropdownLocatorFormat = "accordion__heading-%d";
    private String textInputLocatorFormat = "accordion__panel-%d";



    public void clickClosedDropdownByIndex(int index) {
        driver.findElement(By.id(String.format(closedDropdownLocatorFormat, index))).click();
    }


    public String getTextFromTextInputByIndex(int index) {
        return  driver.findElement(By.id(String.format(textInputLocatorFormat, index))).getText();
    }



    public void scrollToTable() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }


}
