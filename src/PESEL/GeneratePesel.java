package PESEL;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static generalMethods.StringOperations.randomCharacterFromString;

public class GeneratePesel {
    static String pesel;

    public String generatePesel() {
        GregorianCalendar birthdate = generateDate(1900, 2010);
        String randomString = randomCharacterFromString("KM");
        return generatePesel(birthdate, randomString);
    }

    private static String addControlNumberAndReturnPesel(String pesel) {
        byte PESEL[] = new byte[10];
        for (int i = 0; i < 10; i++) {
            PESEL[i] = Byte.parseByte(pesel.substring(i, i + 1));
        }

        int sum = 9 * PESEL[0] + 7 * PESEL[1] + 3 * PESEL[2] + 1 * PESEL[3] + 9 * PESEL[4] + 7 * PESEL[5] + 3 * PESEL[6] + 1 * PESEL[7] + 9 * PESEL[8] + 7 * PESEL[9];
        sum %= 10;
        return pesel + sum;
    }

    private static GregorianCalendar generateDate(int startYear, int endYear) {
        GregorianCalendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, randBetween(startYear, endYear));
        date.set(Calendar.DAY_OF_YEAR, randBetween(1, date.getActualMaximum(Calendar.DAY_OF_YEAR)));
        return date;
    }


    private static String returnMonthShiftedByYear(GregorianCalendar date) {
        {
            if (date.get(Calendar.YEAR) < 1900 || date.get(Calendar.YEAR) > 2299) {
                System.out.print("Nie mozlliwe");
            }
            int monthShift = (date.get(Calendar.YEAR) - 1900) / 100 * 20;
            return new Integer(date.get(Calendar.MONTH) + 1 + monthShift).toString();
        }

    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static String randsBetween(int start, int end, int count) {
        String rands = "";
        int i = 0;
        while (i < count) {
            rands += (start + (int) Math.round(Math.random() * (end - start)));
            i++;
        }
        return rands;
    }

    public static String generatePesel(GregorianCalendar birthdate) {
        String randomString = randomCharacterFromString("WM");
        return generatePesel(birthdate, randomString);
    }

    public static String generatePesel(GregorianCalendar birthdate, String sex) {
        String year = (String) (String.valueOf(birthdate.get(Calendar.YEAR))).subSequence(2, 4);
        String peselMonth = returnMonthShiftedByYear(birthdate);
        if (peselMonth.length() == 1) {
            peselMonth = "0" + peselMonth;
        }
        String day = String.valueOf(birthdate.get(Calendar.DAY_OF_MONTH));
        if (day.length() == 1) {
            day = "0" + day;
        }
        String value = null;
        switch (sex) {
            case "W":
                value = String.valueOf(randBetween(0, 4) * 2);
                break;
            case "M":
                value = String.valueOf(randBetween(1, 5) * 2 - 1);
                break;
            default:
                System.out.println("Nieprawidłowa wartość dla płci. Dopuszczalne wartości to: M-mężczyzna, W-kobieta");
        }
        try {
            String pesel = year + peselMonth + day + randsBetween(0, 9, 3) + value;
            return addControlNumberAndReturnPesel(pesel);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
