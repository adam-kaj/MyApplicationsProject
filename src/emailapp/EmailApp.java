package emailapp;

public class EmailApp
{
    public static void main(String[] args){
        Email em1 = new Email("John","Smith");
        em1.setAlternateEmail("a.m.@kopek.pl");
        em1.setMailboxCapacity(500);
        em1.ShowInfo();}
}
