package auth.dayTripMarrakesh.dataHelper;

import com.github.javafaker.Faker;
import lombok.Value;

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

    public static EndOfActionCardMonth getEndOfActionCardMonth() {
        int random = (int) (Math.random()*12 + 1);
        String monthRandom = String.valueOf(random);
        if ( random < 10 ) {
            monthRandom = "0" + random;
        }
        return new EndOfActionCardMonth(monthRandom);
    }

    public static EndOfActionCardYear getEndOfActionCardYear() {

        int random = (int) (Math.random()*40 + 1);
        String yearRandom = String.valueOf(random);
        if ( random < 10 ) {
            yearRandom = "0" + random;
        }
        return new EndOfActionCardYear(yearRandom);
    }

    public static EndOfActionCardYear getValidEndOfActionCardYear() {
        Calendar calendar = Calendar.getInstance();

        int year = Integer.parseInt(DataHelper.getEndOfActionCardYear().getYear());
        int month = Integer.parseInt(DataHelper.getEndOfActionCardMonth().getMonth());

            int currentMonth = calendar.get(Calendar.MONTH)+1;
            int currentYear = calendar.get(Calendar.YEAR) - 2000;

            if ( year < currentYear ) {
                year = currentYear;
            }
            if ( month < currentMonth ) {
                year = currentYear+1;
            }
        return new EndOfActionCardYear(String.valueOf(year));
    }

    public static EndOfActionCardYear getInvalidEndOfActionCardYear() {
        Calendar calendar = Calendar.getInstance();

        int year = Integer.parseInt(DataHelper.getEndOfActionCardYear().getYear());
        int month = Integer.parseInt(DataHelper.getEndOfActionCardMonth().getMonth());

        int currentMonth = calendar.get(Calendar.MONTH)+1;
        int currentYear = calendar.get(Calendar.YEAR) - 2000;

        if ( year >= currentYear) {
            year = currentYear - 1;
        }
        return new EndOfActionCardYear(String.valueOf(year));
    }

    public static OwnerCard getOwnerCard() {
        return new OwnerCard(faker.name().firstName());
    }

    public static CVCCodeCard getValidCVCCode() {
        return new CVCCodeCard(String.valueOf(Math.random()*899 + 100));
    }

    public static CVCCodeCard getInvalidCVCCode() {
        return new CVCCodeCard(String.valueOf(Math.random()*100));
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
}
