package auth.dayTripMarrakesh.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DayTripPage {

    private final SelenideElement buyTrip = $x("//*[@class='button button_size_m button_theme_alfa-on-white']");
    private final SelenideElement buyCreditTrip = $x("//*[@type='button']//*[contains(text(), 'Купить в кредит')]");
    private final SelenideElement textAfterBuyTrip = $x("//*[contains(text(), 'Оплата по карте')]");
    private final SelenideElement textAfterBuyCreditTrip = $x("//*[contains(text(), 'Кредит по данным карты')]");

    public DayTripPage cardPayment() {
        buyTrip.click();
        //textAfterBuyTrip.shouldBe(visible);
        return new DayTripPage();
    }

    public DayTripPage creditPayment() {
        buyCreditTrip.click();
        //textAfterBuyCreditTrip.shouldBe(visible);
        return new DayTripPage();
    }
}