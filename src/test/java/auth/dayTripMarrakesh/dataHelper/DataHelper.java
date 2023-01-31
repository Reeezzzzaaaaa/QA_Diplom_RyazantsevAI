package auth.dayTripMarrakesh.dataHelper;

import com.github.javafaker.Faker;
import lombok.Value;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

public class DataHelper {

    private static Faker faker = new Faker(new Locale("en"));

    DataHelper() {
    }

    public static CardNumber getFirstCard() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getSecondCard() {
        return new CardNumber("4444 4444 4444 4442");
    }

    public static CardNumber getZeroCard() {
        return new CardNumber("4444 4444 4444 4440");
    }

    public static CardNumber getThirdCard() {
        return new CardNumber("4444 4444 4444 4443");
    }

    public static CardNumber getEmptyCard() {
        return new CardNumber("");
    }

    public static EndOfActionCardMonth get13Month() {return new EndOfActionCardMonth("13");}

    public static EndOfActionCardMonth getWithOutZeroBeforeMonth() {return new EndOfActionCardMonth("7");}

    public static EndOfActionCardMonth get00Month() {return new EndOfActionCardMonth("00");}

    public static EndOfActionCardMonth getEmptyMonth() {return new EndOfActionCardMonth("");}

    public static EndOfActionCardYear get27Year() {
        return new EndOfActionCardYear("27");
    }

    public static EndOfActionCardYear get28Year() {
        return new EndOfActionCardYear("28");
    }

    public static EndOfActionCardYear get29Year() {
        return new EndOfActionCardYear("29");
    }

    public static EndOfActionCardYear getEmptyYear() {
        return new EndOfActionCardYear("");
    }

    public static EndOfActionCardMonth getEndOfActionCardMonth() {
        int random = (int) (Math.random() * 12+1);
        String monthRandom = String.valueOf(random);
        if ( random < 10 ) {
            monthRandom = "0"+random;
        }
        return new EndOfActionCardMonth(monthRandom);
    }

    public static EndOfActionCardYear getEndOfActionCardYear() {

        int random = (int) (Math.random() * 28+1);
        String yearRandom = String.valueOf(random);
        if ( random < 10 ) {
            yearRandom = "0"+random;
        }
        return new EndOfActionCardYear(yearRandom);
    }

    public static EndOfActionCardYear getValidEndOfActionCardYear() {
        Calendar calendar = Calendar.getInstance();

        int year = Integer.parseInt(DataHelper.getEndOfActionCardYear().getYear());

        int currentYear = calendar.get(Calendar.YEAR)-2000;

        if ( year <= currentYear ) {
            year = currentYear + 1;
        }
        return new EndOfActionCardYear(String.valueOf(year));
    }

    public static EndOfActionCardYear getInvalidEndOfActionCardYear() {
        Calendar calendar = Calendar.getInstance();

        int year = Integer.parseInt(DataHelper.getEndOfActionCardYear().getYear());

        int currentYear = calendar.get(Calendar.YEAR)-2000;

        if ( year >= currentYear ) {
            year = currentYear-1;
        }
        return new EndOfActionCardYear(String.valueOf(year));
    }

    public static OwnerCard getOwnerCard() {
        return new OwnerCard(faker.name().firstName());
    }

    public static OwnerCard getEmptyFieldOwnerCard() {
        return new OwnerCard("");
    }

    public static OwnerCard getOneSymbolFieldOwnerCard() {
        return new OwnerCard("A");
    }

    public static OwnerCard getCyrillicOwnerCard() {
        return new OwnerCard("Петров");
    }

    public static CVCCodeCard getValidCVCCode() {
        return new CVCCodeCard(faker.numerify("###"));
    }

    public static CVCCodeCard getInvalidCVCCode() {
        return new CVCCodeCard(faker.numerify("##"));
    }

    public static CVCCodeCard getEmptyFieldCVCCode() {
        return new CVCCodeCard(faker.numerify(""));
    }

    public static StatusEntity getStatus() {
        DbUtils dbUtils = new DbUtils();
        return new StatusEntity(dbUtils.getStatusEntity());}

    public static StatusEntity getApprovedStatus() {
        return new StatusEntity("APPROVED");
    }

    public static StatusEntity getDeclinedStatus() {
        return new StatusEntity("DECLINED");
    }

    @Value
    public static class CardNumber {
        private String number;
    }

    @Value
    public static class EndOfActionCardMonth {
        private String month;
    }

    @Value
    public static class EndOfActionCardYear {
        private String year;
    }

    @Value
    public static class OwnerCard {
        private String owner;
    }

    @Value
    public static class CVCCodeCard {
        private String cvcCode;
    }

    @Value
    public static class StatusEntity {
        private String status;
    }
}
