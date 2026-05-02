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
    //Локатор нижней кнопки "Заказать"//

    //Скролл и клик на нижнюю кнопку "Заказать"
    public void scrollToOrderDownButtonAndClick() {
        WebElement element = driver.findElement(orderDownButton);
        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

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
