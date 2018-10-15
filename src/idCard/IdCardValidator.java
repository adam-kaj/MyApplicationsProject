package idCard;

import java.util.List;

import static generalMethods.ListOperations.stringToList;
import static idCard.IdCardGenerate.getValuesCharacters;

public class IdCardValidator {
    static String idCard;

    public IdCardValidator(String idCard) {
        boolean flag = true;
        if (idCard.length() != 9) {
            System.out.println("Nieprawidłowa ilość znaków dla dokumentu osobistego");
        } else {
            List idCardList = stringToList(idCard);
            for (int i = 0; i <= 2; i++) {
                flag = flag && !(((String) idCardList.get(i)).matches("[A-Z]]"));
            }
            for (int i = 3; i < 9; i++) {
                flag = flag && !(((String) idCardList.get(i)).matches("[0-9]]"));
            }
            if (!flag) {
                System.out.println("Nieprawidłowy format dokumentu");
            }else{
                flag = flag && checkSumIdCard(idCardList);
            if(flag){
                System.out.println("Dowód prawidłowy");
            }else{
                System.out.println("Dowód nieprawidłowy");
            }
            }
        }
    }

    private boolean checkSumIdCard(List idCard) {
        int checkInteger;
        checkInteger = 7 * getValuesCharacters(idCard.get(0)) + 3 * getValuesCharacters(idCard.get(1)) + 1 * getValuesCharacters(idCard.get(2)) + 7 * getValuesCharacters(idCard.get(4)) + 3 * getValuesCharacters(idCard.get(5)) + 1 * getValuesCharacters(idCard.get(6)) + 7 * getValuesCharacters(idCard.get(7)) + 3 * getValuesCharacters(idCard.get(8));
        checkInteger = (char) checkInteger % 10;
        String check = String.valueOf(checkInteger);
        return check.equals(idCard.get(3));
    }
}
