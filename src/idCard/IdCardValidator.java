package idCard;

import java.util.List;

import static generalMethods.ListOperations.stringToList;
import static idCard.IdCardGenerate.getValuesCharacters;

public class IdCardValidator {
    static String idCard;

    public IdCardValidator(String idCard){
        if(idCard.length() != 9){
            System.out.println("Nieprawidłowa ilość znaków dla dokumentu osobistego");
        }else{
            List idCardList = stringToList(idCard);
            boolean flag=true;
            for (int i=0; i<=2; i++){
                flag = flag && !(((String) idCardList.get(i)).matches("[A-Z]]"));
            }
        }
    }
}
