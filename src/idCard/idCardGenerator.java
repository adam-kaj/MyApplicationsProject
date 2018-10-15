package idCard;

public class idCardGenerator {
    public static void main(String args[]) {
        System.out.println("Tu dostaniesz numer dowodu!!");
        String idCard = new IdCardGenerate().generateIdCard();
        System.out.println(idCard);
        IdCardValidator validator = new IdCardValidator(idCard);

    }
}
