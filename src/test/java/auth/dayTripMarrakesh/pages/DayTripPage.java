package auth.dayTripMarrakesh.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DayTripPage {

    private final SelenideElement buyTrip = $x("//*[@class='App_appContainer__3jRx1']/button[1]");
    private final SelenideElement buyCreditTrip = $x("//*[@class='App_appContainer__3jRx1']/button[2]");

    public void cardPayment() {
        buyTrip.click();
        new DayTripPage();
    }

    public void creditPayment() {
        buyCreditTrip.click();
        new DayTripPage();
    }
}