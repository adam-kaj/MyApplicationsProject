package idCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static generalMethods.ListOperations.*;

public class IdCardGenerate {

    static ArrayList<Object> chars = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
    static ArrayList<Object> idCardArray = new ArrayList<>();

    static String generateIdCard() {
        idCardArray = GenerateValuesFromList(chars.subList(10, 35), 3);
        idCardArray.addAll(GenerateValuesFromList(chars.subList(0, 9), 6));
        return listToString(idCardArray.subList(0,3))+checkSumIdCard(idCardArray)+listToString(idCardArray.subList(4,9));
    }

    private static ArrayList<Object> GenerateValuesFromList(List<Object> chars, int i) {
        ArrayList<Object> values = new ArrayList<>();
        for (int k = 0; k < i; k++) {
            values.add(chars.get((int) (Math.random() * chars.size())));
        }
        return values;
    }

    private static String checkSumIdCard(ArrayList<Object> idCard) {
        int checkInteger;
        checkInteger = 7 * getValuesCharacters(idCard.get(0)) + 3 * getValuesCharacters(idCard.get(1)) + 1 * getValuesCharacters(idCard.get(2)) + 7 * getValuesCharacters(idCard.get(4)) + 3 * getValuesCharacters(idCard.get(5)) + 1 * getValuesCharacters(idCard.get(6)) + 7 * getValuesCharacters(idCard.get(7)) + 3 * getValuesCharacters(idCard.get(8));
        checkInteger = (char) checkInteger % 10;
        idCard.set(3, String.valueOf(checkInteger));
        return (String) idCard.get(3);
    }

    protected static Integer getValuesCharacters(Object k) {
        int value = -1;
        for (int i = 0; i <= 35; i++) {
            if (k.equals(chars.get(i))) {
                value = i;
                break;
            }

        }
        return value;
    }
}