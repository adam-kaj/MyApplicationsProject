package PESEL;


import java.util.Date;
import java.util.GregorianCalendar;

import static PESEL.GeneratePesel.generatePesel;

public class PeselGeneratorBeta {
    public static void main(String args[]) {
        GregorianCalendar date = new GregorianCalendar();
        date.set(1990, 11, 25);
        System.out.println(date.get(GregorianCalendar.YEAR));
        String pesel = generatePesel(date, "W");
        if (pesel != null) {
            System.out.println("Twój wylosowany PESEL to: " + pesel);
            PeselValidator peselVal = new PeselValidator(pesel);
            if (peselVal.isValid()) {
                System.out.println("Numer PESEL jest prawidłowy");
                System.out.println("Rok urodzenia: " + peselVal.getBirthYear());
                System.out.println("Miesiąc urodzenia: " + peselVal.getBirthMonth());
                System.out.println("Dzień urodzenia: " + peselVal.getBirthDay());
                System.out.println("Płeć: " + peselVal.getSex());
            } else {
                System.out.println("Numer PESEL jest nieprawidłowy");
            }
        } else System.out.println("Prośba o wprowadzenie prawidłowych danych");
    }
}

