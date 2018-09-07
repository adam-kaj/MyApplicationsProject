package PESEL;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.Random;

public class PESELGenerator {
    public static void main(String[] args) {
//        File file = new File(System.getProperty("user.dir") + "/" + "NewPesel");
        GetPesel();
    }
    Random rand = new Random();

    public static void GetPesel() {
        int[] pesel = new int[11];
        String peselString = "";
        //Generowanie cyfr 1-3
        for (int i = 0; i < 2; i++) {
            pesel[i] = (int) (Math.random() * 10);
        }
        //generowanie cyfry 4
        switch (pesel[2] % 2) {
            case 0:
                if (pesel[2] == 0) {
                    pesel[3] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}[(int) (Math.random() * 4)];
                } else pesel[3] = (int) (Math.random() * 10);
            case 1:
                pesel[3] = new int[]{0, 1, 2}[(int) (Math.random() * 3)];
        }
        //generowanie cyfry 5
        pesel[4] = new int[]{0, 1, 2, 3}[(int) (Math.random() * 4)];
        //generowanie cyfry 6
        if (pesel[4] == 3) {
            pesel[5] = new int[]{0, 1}[(int) (Math.random() * 2)];
        } else pesel[5] = (int) (Math.random() * 10);
        //generowanie cyfr 7-10
        for (int i = 6; i < 9; i++) {
            pesel[i] = (int) (Math.random() * 10);
        }
        //generowanie liczby kontrolnej
        pesel[10] = (9 * pesel[0] + 7 * pesel[1] + 3 * pesel[2] + 1 * pesel[3] + 9 * pesel[4] + 7 * pesel[5] + 3 * pesel[6] + 1 * pesel[7] + 9 * pesel[8] + 7 * pesel[9]) % 10;

        //drukowanie numeru PESEL
        for (int count : pesel) {
            peselString += count;
        }
        System.out.print(peselString);
    }
//            public String Generate()
//        {
//            StringBuilder peselStringBuilder = new StringBuilder();
//            Date birthDate = GenerateDate(1900, 2099);
//
//            AppendPeselDate(birthDate, peselStringBuilder);
//
//            peselStringBuilder.append(GenerateRandomNumbers(4));
//
//            peselStringBuilder.append(PeselCheckSumCalculator.Calculate(peselStringBuilder.toString()));
//
//            return peselStringBuilder.toString();
//        }
//
//        public static String GetPeselMonthShiftedByYear(Date date)
//        {
//            if(date.getYear() < 1900 || date.getYear() > 2299)
//            {
//                System.out.print("Nie mozlliwe");
//            }
//
//            int monthShift = (Integer) ((date.getYear() - 1900) / 100) * 20;
//
//
//            return new Integer(date.getMonth() + monthShift).toString();
//        }
//
//        private Date GenerateDate(int yearFrom, int yearTo)
//        {
//            int year = rand.nextInt((yearTo - yearFrom + 1)) + yearFrom;
//            int month = rand.nextInt(12)+1;
//            int maxDays = LocalDate.of(year,month,1).lengthOfMonth();
//            int day = rand.nextInt(maxDays)+1;
//            return new Date(year, month, day);
//        }
//
//        private void AppendPeselDate(Date date, StringBuilder builder)
//        {
//            builder.append((date.getYear() % 100).toString("00"));
//            builder.append(GetPeselMonthShiftedByYear(date));
//            builder.append(toString(date.getDate()));
//        }
//
//    private String toString(int date) {
//        return String.valueOf(date);
//    }
//
//    private int GenerateRandomNumbers(int numbersCount)
//        {
//            int maxValue = (int)Math.Pow(10, numbersCount);
//            String format = "D" + numbersCount;
//
//            return rand.NextInt(maxValue).ToString(format);
//        }
//    }
//}
}
