package auth.dayTripMarrakesh.test;

import auth.dayTripMarrakesh.dataHelper.DataHelper;
import auth.dayTripMarrakesh.dataHelper.DbUtils;
import auth.dayTripMarrakesh.pages.CreditGatePage;
import auth.dayTripMarrakesh.pages.DayTripPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static auth.dayTripMarrakesh.dataHelper.DbUtils.cleanDB;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditGateTests {

    @BeforeEach
    void openPage() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown(){
        cleanDB();
    }

    @Test
    void shouldSuccessByDayTripFromFirstCardTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getFirstCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.successNotification();
        assertEquals(DataHelper.getApprovedStatus(), DataHelper.getStatus());
    }

    @Test
    void shouldUnSuccessByDayTripFromSecondCardTest999999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        assertEquals(DataHelper.getDeclinedStatus(), DataHelper.getStatus());
        purchase.unSuccessNotification();
    }

    @Test
    void shouldUnSuccessByDayTripFromThirdCardTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getThirdCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.unSuccessNotification();
    }

    @Test
    void shouldUnSuccessByDayTripFromZeroCardTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getZeroCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.unSuccessNotification();
    }

    @Test
    void shouldUnSuccessByDayTripFromEmptyCardTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getEmptyCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldNumberCard();
    }

    @Test
    void shouldUnSuccessByDayTripWithEndOfActionMonth13MonthTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.get13Month(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldMonth();
    }

    @Test
    void shouldUnSuccessByDayTripWithEndOfActionYearCardWithOutZeroBeforeMonthTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getWithOutZeroBeforeMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldMonth();
    }

    @Test
    void shouldUnSuccessByDayTripWithEndOfActionCard00MonthTest99999999999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.get00Month(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldMonth();
    }

    @Test
    void shouldUnSuccessByDayTripWithEmptyFieldEndOfActionCardTMonthTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEmptyMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldMonth();
    }

    @Test
    void shouldSuccessByDayTripWithEndOfActionCard2027YearTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.get27Year());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.successNotification();
    }

    @Test
    void shouldSuccessByDayTripWithEndOfActionCard2028YearTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.get28Year());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.successNotification();
    }

    @Test
    void shouldSuccessByDayTripWithEndOfActionCard2029YearTest9999999999999999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.get29Year());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.successNotification();
    }

    @Test
    void shouldUnSuccessByDayTripWithEndedOfActionCardYearTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getInvalidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldYear();
    }

    @Test
    void shouldUnSuccessByDayTripWithEmptyFieldEndOfActionCardYearTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getEmptyYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldYear();
    }

    @Test
    void shouldUnSuccessByDayTripWithEmptyFieldOwnerTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getEmptyFieldOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldOwner();
    }

    @Test
    void shouldUnSuccessByDayTripWithOneSymbolOwnerTest99999999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOneSymbolFieldOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldOwner();
    }

    @Test
    void shouldUnSuccessByDayTripWithCyrillicOwnerTest9999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getCyrillicOwnerCard(), DataHelper.getValidCVCCode());
        purchase.postData();
        purchase.wrongFieldOwner();
    }

    @Test
    void shouldUnSuccessByDayTripWithTwoSymbolsWithOutZeroBeforeCVCCodeTest() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getInvalidCVCCode());
        purchase.postData();
        purchase.wrongFieldCVCCode();
    }

    @Test
    void shouldUnSuccessByDayTripWithEmptyFieldCVCCodeTest99999999999999999999999999999999999999999999999999() {

        DayTripPage chooseMethod = new DayTripPage();
        chooseMethod.creditPayment();
        CreditGatePage purchase = new CreditGatePage();
        purchase.numberCard(DataHelper.getSecondCard());
        purchase.EndOfActionDateCard(DataHelper.getEndOfActionCardMonth(), DataHelper.getValidEndOfActionCardYear());
        purchase.dataCard(DataHelper.getOwnerCard(), DataHelper.getEmptyFieldCVCCode());
        purchase.postData();
        purchase.wrongFieldCVCCode();
        purchase.wrongFieldOwnerNotBeVisible();
    }
}
