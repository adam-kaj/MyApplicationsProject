package PESEL;


public class PeselGeneratorBeta {
    public static void main(String args[]) {
        String pesel = new GeneratePesel().GeneratePesel();
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
    }

}

