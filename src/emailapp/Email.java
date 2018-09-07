package emailapp;

import java.util.Scanner;

public class Email {
    private String companySuffix = "yorcompany.com";
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int defaultPasswordLength =10;
    private String company;
    private int mailboxCapacity;
    private String alternateEmail;

    //Constuctor to receive the first name and last name
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = setDepartment();
        this.password = setPassword(defaultPasswordLength);
        this.email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+ department + companySuffix;
    }

        //Call a method asking for the deparment - return the department
        //Ask for department
    private String setDepartment() {
            System.out.println("DEPARTMENT CODE\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n enter department code");
            Scanner in = new Scanner(System.in);
            int depChoice = in.nextInt();
            if (depChoice == 1) {
                return "sales";
            } else if (depChoice == 2) {
                return "dev";
            } else if (depChoice == 3) {
                return "acct";
            } else {
                return "";
            }
        }
    //Generate a random password
    private String setPassword(int lengthPassword){
        String string = "ABCDEFGHIJKLMNOPRSTUWZQY1234567890!@#$%&*";
        char[] password = new char[lengthPassword];
        for(int i=0;i<lengthPassword;i++){
            int random =  (int) (Math.random() * string.length());
            password[i] = string.charAt(random);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public void ShowInfo(){
        System.out.println("DISPLAY NAME: " + firstname + "" + lastname +
                            "\nCOMPANY MAIL: " + email +
                            "\nPASSWORD: " + password +
                            "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb");
    }
}
