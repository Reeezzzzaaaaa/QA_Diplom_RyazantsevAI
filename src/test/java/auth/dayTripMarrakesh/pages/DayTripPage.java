package auth.dayTripMarrakesh.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DayTripPage {

    private final SelenideElement buyTrip = $x("//*[@class='App_appContainer__3jRx1']/button[1]");
    private final SelenideElement buyCreditTrip = $x("//*[@class='App_appContainer__3jRx1']/button[2]");

    public DayTripPage cardPayment() {
        buyTrip.click();
        return new DayTripPage();
    }

    public DayTripPage creditPayment() {
        buyCreditTrip.click();
        return new DayTripPage();
    }
}