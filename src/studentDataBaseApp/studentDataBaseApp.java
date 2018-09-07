package studentDataBaseApp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class studentDataBaseApp {
    public static void main(String[] args) {

//        String a = "Kod sms dla transakcji o wartości 123456,09 to:123456*";
//        Pattern pattern = Pattern.compile("[0-9]{6}\\b$|[0-9]{6}\\b\\*");
//        Matcher matcher = pattern.matcher(a);
//        System.out.print(matcher);

        String stringToSearch = "Kod sms dla transakcji o wartości 654321,09 to:123456*";

        Pattern p = Pattern.compile("[0-9]{6}$|\\d{6}(<?=\\*)");   // the pattern to search for
        Matcher m = p.matcher(stringToSearch);

        // now try to find at least one match
        if (m.find())
            System.out.println(m.group());
        else
            System.out.println("Did not find a match");
//        System.out.println("Enter number of new student");
//        Scanner in = new Scanner(System.in);
//        int numStudents = in.nextInt();
//
//        Student[] students = new Student[numStudents];
//        for(int i=0; i<numStudents; i++){
//            students[i] = new Student();
//            students[i].enroll();
//            students[i].payTution();
//        }
//
//        for(int i = 0; i<numStudents; i++){
//            System.out.print(students[i].toString());
//        }
    }
}
