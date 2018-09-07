package studentDataBaseApp;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private static String courses;
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;
    //Constructor: prompt user to enter student's name and year

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name:");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name:");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshman\n2 - Sophmore\n3 - Junior\n 4 - Senior\nEnter student class level:");
        this.gradeYear = in.nextLine();
        setID();
        System.out.println("Student ID: " + studentID);

    }

    //Generate an ID
    private void setID() {
        //Grade level + id
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        do {
            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (true);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);

    }

    public void payTution() {
        viewBalance();
        do{
        try {
            System.out.println("Enter your payment: $" );
            Scanner in = new Scanner(System.in);
            int payment = in.nextInt();
            tuitionBalance = tuitionBalance - payment;
            viewBalance();
            break;
        }
            catch(Exception e){
            System.out.println("Wprowadź prawidłową kwotę");
            continue;
        }}
        while(true);
    }
    //Show status
    public String showStatus(){
        return "Name:  " + firstName + " " + lastName +
                "\nLevel: " + gradeYear +
                "\nStudent ID" + id +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

    @Override
    public String toString(){
        return "Name:  " + firstName + " " + lastName +
                "\nLevel: " + gradeYear +
                "\nStudent ID" + id +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

}

