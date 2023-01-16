package auth.dayTripMarrakesh.test;

import auth.dayTripMarrakesh.dataHelper.DataHelper;
import auth.dayTripMarrakesh.pages.DayTripPage;
import auth.dayTripMarrakesh.pages.PurchasePage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTests {

        @BeforeEach
        void openPage() {
            Configuration.holdBrowserOpen = true;
            open("http://localhost:8080/");
        }

//    @AfterAll
//    public static void tearDown() {
//        cleanDB();
//    }

    @Test
    void shouldSuccessByDayTripTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.cardPayment();
        PurchasePage purchase = new PurchasePage();
        purchase.numberCard(DataHelper.getFirstCard());
        purchase.monthCard(DataHelper.getEndOfActionCardMonth());
        purchase.yearCard(DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
    }
}
