package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    private By rentFormHeader = By.xpath("//div[contains(text(), 'Про аренду')]");
    private By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath("//div[contains(@class, 'Dropdown-control')]");
    private By colorBlackCheckbox = By.xpath("//input[@id='black']");
    private By colorGreyCheckbox = By.xpath("//input[@id='grey']");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(text(), 'Заказать')]");
    private By confirmYesButton = By.xpath("//button[contains(text(), 'Да')]");
    private By successMessage = By.xpath("//div[contains(text(), 'Заказ оформлен')]");



    public void fillOrderForm2(String deliveryDate, String comment) {
        //  Заполнение даты
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(deliveryDateField));
        dateField.click();
        dateField.clear();
        dateField.sendKeys(deliveryDate);
        dateField.sendKeys(Keys.ENTER);


        //  Выбор срока аренды
        WebElement periodField = wait.until(ExpectedConditions.elementToBeClickable(rentalPeriodField));
        periodField.click();


        By periodOption = By.xpath("//div[contains(@class, 'Dropdown-option')]");
        wait.until(ExpectedConditions.elementToBeClickable(periodOption)).click();


        //  Выбор цвета
        WebElement colorCheckbox = wait.until(ExpectedConditions.elementToBeClickable(colorBlackCheckbox));
        colorCheckbox.click();


        //  Заполнение комментария
        WebElement commentElement = wait.until(ExpectedConditions.elementToBeClickable(commentField));
        commentElement.sendKeys(comment);

    }

    public void clickOrderButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        button.click();

    }

    public boolean isConfirmationModalDisplayed() {
        System.out.println("Ожидаем появление окна подтверждения...");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmYesButton));

        return element.isDisplayed();
    }

    public void clickConfirmYesButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
        button.click();
        }

    public boolean isSuccessMessageDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        return element.isDisplayed();
    }
}
