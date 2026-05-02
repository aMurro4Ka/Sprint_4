
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class OrderTests extends BaseTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;


    //Конструктор
    public OrderTests(String firstName, String lastName, String address, String phoneNumber,
                      String deliveryDate, String rentalPeriod, String color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Настя", "Попова", "Сиэтл", "79991112233", "05.07.2025", "сутки", "black", "Звоните после 14 часов"},
                {"Дима", "Алешин", "Вашингтон", "79994445566", "31.12.2025", "двое суток", "grey", "Акуна-Матата!"},
                {"Мария", "Воронина", "Лос-Анджелес", "79998833766", "01.01.2026", "трое суток", "black", "Не звонить, только смс"},
        };
    }



    @Test
    public void testFullOrderByFirstButton() {
        mainPage.clickOrderUpButton(); //Клик на верхнюю кнопку "Заказать" на главной странице

        forWhomScooterPage.fillOrderForm1(firstName, lastName, address, phoneNumber);  //Заполняется форма "Для кого самокат"
        forWhomScooterPage.nextButtonClick(); //Клик на кнопку "Далее"



        // Заполнение формы "Про аренду"
        aboutRentPage.fillOrderForm2(deliveryDate, comment);

        // Клик на кнопку "Заказать"
        aboutRentPage.clickOrderButton();


        //  Клик на кнопку "Да" в окне подтверждения
        aboutRentPage.clickConfirmYesButton();

        // ПРОВЕРКА - появилось ли сообщение об успешном заказе
        Assert.assertTrue("Сообщение об успешном заказе не появилось",
                aboutRentPage.isSuccessMessageDisplayed());


    }


}
