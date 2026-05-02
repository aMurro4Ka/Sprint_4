
import org.junit.Test;
import org.junit.Assert;

public class SecondOrderButtonTest extends BaseTest{


    @Test
    public void SecondOrderButton() {
        mainPage.scrollToOrderDownButtonAndClick(); //Скролл и клик на нижнюю кнопку "Заказать" на главной странице//
        Assert.assertTrue("Текст 'Для кого самокат' не виден",
                forWhomScooterPage.isOrderDoneTextVisible()); //Проверяется наличие текста "Для кого самокат"
    }


}